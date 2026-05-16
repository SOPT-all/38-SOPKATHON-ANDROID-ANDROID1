package org.sopt.soptackthon_app_1.presentation.yubin

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import kotlinx.coroutines.launch
import org.sopt.soptackthon_app_1.R
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_1.core.util.noRippleClickable
import org.sopt.soptackthon_app_1.presentation.gabyu.component.BottomSheetContent
import org.sopt.soptackthon_app_1.presentation.gabyu.component.ShareType
import org.sopt.soptackthon_app_1.presentation.yerim.component.YerimButtonComponent
import java.io.File

@Composable
fun YubinRoute(
    navigateToGabyu: () -> Unit,
    viewModel: YubinViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.isSuccess) {
        if (uiState.isSuccess) {
            viewModel.resetState()
        }
    }

    YubinScreen(
        uiState = uiState,
        onBackClick = navigateToGabyu, // 임시로 뒤로가기도 Gabyu로
        onTitleChange = viewModel::updateTitle,
        onImageCapture = viewModel::updateImageUri,
        onSaveClick = viewModel::postRecord,
        onShareToBoard = viewModel::shareToBoard
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YubinScreen(
    uiState: YubinUiState,
    onRecordClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
    onTitleChange: (String) -> Unit = {},
    onImageCapture: (Uri) -> Unit = {},
    onSaveClick: () -> Unit = {},
    onShareToBoard: () -> Unit = {}
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var tempUri by remember { mutableStateOf<Uri?>(null) }
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedShareType by remember { mutableStateOf<ShareType?>(null) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = { success ->
            if (success && tempUri != null) {
                onImageCapture(tempUri!!)
            }
        }
    )

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                val uri = createTempImageUri(context)
                tempUri = uri
                cameraLauncher.launch(uri)
            }
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SopkathonTheme.colors.white)
            .verticalScroll(rememberScrollState())
    ) {
        // Top Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 9.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .noRippleClickable(onBackClick)
                    .size(24.dp),
                tint = Color.Unspecified
            )
            Text(
                text = "오늘의 기록",
                style = SopkathonTheme.typography.head.head3,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "제목 추가",
                style = SopkathonTheme.typography.head.head6_bold,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(6.dp))
            TextField(
                value = uiState.title,
                onValueChange = onTitleChange,
                placeholder = {
                    Text(
                        text = "제목을 입력해주세요",
                        color = SopkathonTheme.colors.gray500,
                        style = SopkathonTheme.typography.head.head6_medium,
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = SopkathonTheme.colors.gray100,
                    unfocusedContainerColor = SopkathonTheme.colors.gray100,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "사진 추가",
                style = SopkathonTheme.typography.head.head6_bold,
            )

            Spacer(modifier = Modifier.height(7.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(15.dp))
                    .background(SopkathonTheme.colors.gray100)
                    .noRippleClickable {
                        val permissionCheckResult =
                            ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                        if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                            val uri = createTempImageUri(context)
                            tempUri = uri
                            cameraLauncher.launch(uri)
                        } else {
                            permissionLauncher.launch(Manifest.permission.CAMERA)
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                if (uiState.imageUri != null) {
                    AsyncImage(
                        model = uiState.imageUri,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_camara_add),
                            contentDescription = null,
                            tint = Color.Unspecified,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(11.dp))

            Text(
                text = "음성 기록",
                style = SopkathonTheme.typography.head.head6_bold,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(SopkathonTheme.colors.subGreenGray)
                    .padding(horizontal = 13.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(37.dp)
                        .clip(CircleShape)
                        .background(SopkathonTheme.colors.subGreen)
                        .noRippleClickable(onRecordClick),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.icon_recording),
                        contentDescription = null,
                        tint = Color.Unspecified,
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "버튼을 꾸욱 눌러주세요!",
                    color = SopkathonTheme.colors.gray400,
                    style = SopkathonTheme.typography.head.head6_medium,
                )
            }

            Spacer(modifier = Modifier.height(19.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                YerimButtonComponent(
                    onClick = onSaveClick,
                    text = "저장하기",
                    backgroundColor = SopkathonTheme.colors.gray700,
                    textColor = SopkathonTheme.colors.white,
                    modifier = Modifier.weight(1f)
                )

                YerimButtonComponent(
                    onClick = { showBottomSheet = true },
                    text = "공유하기",
                    backgroundColor = SopkathonTheme.colors.gray200,
                    textColor = SopkathonTheme.colors.gray700,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(19.dp))
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            containerColor = SopkathonTheme.colors.white
        ) {
            BottomSheetContent(
                selectedType = selectedShareType,
                onTypeSelected = { type ->
                    selectedShareType = type
                },
                onShareClick = {
                    if (selectedShareType == ShareType.BOARD) {
                        onShareToBoard()
                    }
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            showBottomSheet = false
                        }
                    }
                }
            )
        }
    }
}

private fun createTempImageUri(context: Context): Uri {
    val tempFile = File.createTempFile("temp_image", ".jpg", context.cacheDir).apply {
        createNewFile()
        deleteOnExit()
    }
    return FileProvider.getUriForFile(
        context,
        "${context.packageName}.fileprovider",
        tempFile
    )
}

@Preview(showBackground = true)
@Composable
private fun YubinScreenPreview() {
    SopkathonTheme {
        YubinScreen(uiState = YubinUiState())
    }
}
