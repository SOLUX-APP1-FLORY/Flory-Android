# 🌸 FLORY-Android 🌸
### 플로리 (Flory)
> 29th SOLUX Project</br>
> 프로젝트 기간 : 2024.03.18 ~ 2024.08.04 </br>

“감정의 꽃말을 가진 꽃으로 하루의 감정을 기록하는 일기 앱서비스” </br>
</br>

## 🌸 Contributors
|<img src="https://avatars.githubusercontent.com/u/91470334?s=400&u=4a743fda141cf8a074022b515b0ce3286e6c8560&v=4" width="250" />|<img src="https://avatars.githubusercontent.com/u/145467592?v=4" width="250" />|<img src="https://avatars.githubusercontent.com/u/65457903?v=4" width="250" />|
|:---------:|:---------:|:---------:|
|[이가을](https://github.com/gaeulzzang)|[김세희](https://github.com/sehee0207)|[윤희재](https://github.com/younheejae)|
| **[👑 Team Leader]** </br>일기 기록 및 수정</br>마이페이지</br>자동 로그인 | **[🤖 Team Member]** </br>로그인</br>회원가입 | **[🤖 Team Member]** </br>홈</br>선물</br>이웃목록 |
</br>

## 📷 Screenshot


</br>
</br>

## 👩🏻‍💻 Tech Stack
| Title | Content |
| ------------ | -------------------------- |
| Architecture | Google Architecture, MVVM  |
| Design Pattern | Repository Pattern, Adapter Pattern, Observer Pattern |
| Jetpack Components | AAC Bottom Navigation, Preference Datastore, Lifecycle, ViewModel  |
| Dependency Injection | Hilt  |
| Network | Retrofit, OkHttp, Multipart  |
| Asynchronous Processing | Coroutine(+ Flow)  |
| Third Party Library | Coil, Timber, kotlinSerialization |
| CI | Github Action(KtLint, Compile Check)  |
| Other Tools | Slack, Notion, Figma, Postman  |\
</br>

## 📁 Foldering
```
📦com.flory
├─📂app
│  ├─📂di
│  ├─📂interceptor
├─📂data
│  ├─📂datasource
│  ├─📂datasourceimpl
│  ├─📂dto
│  │  └─📂request
│  │  └─📂response
│  ├─📂mapper
│  ├─📂repositoryimpl
│  ├─📂service
├─📂domain
│  ├─📂entity
│  ├─📂repository
├─📂presentation
│  ├─📂auth
│  ├─📂main
│  ├─📂home
│  ├─📂date
│  ├─📂gift
│  │  └─📂confirm
│  │  └─📂send
│  ├─📂profile
│  ├─📂record
│  ├─📂searchNeighbor
└─📂util
│  ├─📂base
│  ├─📂context
│  ├─📂fragment
```
</br>
