## 🚀 프로젝트 소개
## 1. 서비스 이름 및 간단한 소개
### 서비스 명 : 노화우
**한 줄 소개**: 노화우는 노화가 다가오는 5·60대를 위해 건강한 나이듦의 노하우를 제안하는 서비스를 뜻합니다

## 2. 주요 기능
- 음성 기록: 큰 버튼 한 번으로 녹음 → 음성과 텍스트 동시에 자동 저장
  사진 기록: 사진 + 메타 데이터를 통한 날짜·위치 자동 태깅
- 보관 :"노하우집" 컨셉
  월별 갤러리(캘린더) 뷰: 한 달치 기록이 캘린더 위에 사진 썸네일로 깔리는 형태 → "내 노하우집"이라는 자산감
  날짜 셀을 누르면 그날의 음성+사진 카드 열림
  월 단위로 넘기면서 "올해 봄에 뭘 했더라" 회상 가능
- 공유 : 또래 + 자녀
  또래 공유: 앱 내 "동네 노하우" / "또래 노하우" 피드 (다른 5·60대 사용자들의 공개 기록 둘러보기)
  자녀 공유: 앱의 기록이 자녀와 함께 공유 + notification
  자녀의 반응: 이모지·한 줄 답장 → 부모님 앱에 알림
- 서비스 제공 - 노하우 라이브러리
  카테고리별 둘러보기 (텃밭·산책·약초·절기)
  추천 : "오늘 뭐 할까?" - 날씨·계절 기반 규칙형 추천

## 3. 팀원 역할 분담

| 👑 한유빈<br/>([@oilbeaneda](https://github.com/oilbeaneda)) | 김예림<br/>([@doorimng](https://github.com/doorimng)) | 윤갑유<br/>([@gahbyu](https://github.com/gahbyu)) |
| :---: | :---: | :---: |
| <img width="200px" src="https://github.com/oilbeaneda.png"/> | <img width="200px" src="https://github.com/doorimng.png"/> | <img width="200px" src="https://github.com/gahbyu.png"/> |
| `기록-음성+사진,상세 페이지 ` | `홈-또래 공유 게시판,스플래시` | `나의 기록 노화우집` |

  
## 🛠 Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Network**: Retrofit2, OkHttp3, Kotlinx Serialization
- **Image Loading**: Coil3
- **Architecture**: MVVM
- **Dependency Management**: Version Catalog (libs.versions.toml)

## 📁 Folder Structure

```
org.sopt.soptackthon_app_1
├── core
│   ├── designsystem (Theme, Component)
│   ├── navigation (Route)
│   └── util (Extension, Constants)
├── data
│   ├── dto (Request, Response)
│   ├── network (ApiFactory, ServicePool)
│   └── service (Retrofit Interfaces)
└── presentation
    ├── main (MainActivity, NavHost)
    └── [feature] (Screen, ViewModel, UiState)
```

## 📜 Coding Convention

### Commit

### **1. 커밋 카테고리**

| 카테고리       | 내용                                 |
|------------|------------------------------------|
| `feat`     | 기능 (feature)                       |
| `fix`      | 버그 수정                              |
| `docs`     | 문서 작업 (documentation)              |
| `style`    | 포맷팅, 세미콜론 누락 등, 코드 자체의 변경이 없는 경우   |
| `refactor` | 리팩토링 : 결과의 변경 없이 코드의 구조를 재조정       |
| `test`     | 테스트                                |
| `chore`    | 변수명, 함수명 등 사소한 수정 *ex) .gitignore* |

### Git Flow

: 기본적으로 Git Flow 전략을 이용한다. 작업 시작 시 선행되어야 할 작업은 다음과 같다.

**< Git Flow >**

1. Issue를 생성한다.
2. Branch를 생성한다.
3. Add - Commit - Push - Pull Request 의 과정을 거친다.
    1. commit은 최대한 잘게!!
    2. commit시 issue를 연결한다.
4. Pull Request가 작성되면 작성자 이외의 다른 팀원이 Code Review를 한다.
5. Code Review가 완료되면 Pull Request 작성자가 dev Branch로 merge 한다.
   → ⭐ **merge 후 카톡방에 무조건 말하기** ⭐
6. merge된 작업이 있을 경우, ‼️**다른 브랜치에서 작업을 진행 중이던 개발자는 본인의 브랜치로 merge된 작업을 Pull 받아온다.**‼️

### **1. 브랜치 유형**

| 브랜치 유형    | 내용                           |
|-----------|------------------------------|
| `yubin`    | 한유빈이 작업하는 브랜치         |
| `yerim`    | 김예림이 작업하는 브랜치         |
| `gahbyu`   | 윤갑유가 작업하는 브랜치         |
| `main`    | 완성된 버전의 코드를 저장하는 브랜치         |
| `develop` | 개발이 진행되는 동안 완성된 코드를 저장하는 브랜치 |
| `feature` | 작은 단위의 작업이 진행되는 브랜치          |
| `hotfix`  | 긴급한 오류를 해결하는 브랜치             |

### **2. 브랜치명**

- 유형/#이슈번호-what

  ex) yubin/#30-home-ui, yerim/#1-add-font, hotfix/#18-qa

| 카테고리       | 내용    |
|------------|-------|
| `feat`     | 구현    |
| `mod`      | 수정    |
| `add`      | 추가    |
| `del`      | 삭제    |
| `fix`      | 버그 수정 |
| `refactor` | 리팩토링  |


### **BEFORE**

<img width="380" height="280" alt="KakaoTalk_Photo_2026-05-17-01-12-36" src="https://github.com/user-attachments/assets/fcf7ea31-a804-43ae-a1fe-0f7eea559d98" />

### **AFTER**
<img width="380" height="280" alt="KakaoTalk_20260517_075804536_01" src="https://github.com/user-attachments/assets/efaca5bc-e1da-49db-8c1a-8831ccf03339" />


### **시연영상**

https://github.com/user-attachments/assets/290afcab-d980-435a-b129-9f40a2790d39







