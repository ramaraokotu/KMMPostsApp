# PostsApp (Kotlin Multiplatform Mobile)

A simple and sample _mobile application_ built to demonstrate the use of
_**Kotlin Multiplatform Mobile**_ for developing _Android and iOS_ applications 🚀.

## About 

It simply loads Posts data from API and Posts will be always loaded from Remote data (from API).
**Features:**
- [x] Clean and Simple UI 🎨


### 📱 Preview

Currently, the app looks like this on the both platforms:

### About this project. 
This is a sample KMM project which tries to shares as much as code possible between Android and iOS. 

Android App                          |  iOS App
:-------------------------:|:-------------------------:
<img src="https://github.com/ramaraokotu/KMMPostsApp/blob/main/android.png" width="400" height="800">  | <img src="https://github.com/ramaraokotu/KMMPostsApp/blob/main/Simulator%20Screenshot%20-%20iPhone%2015%20Pro%20-%202024-10-13%20at%2004.21.15.png" width="400" height="800">

## Built with 

- [Kotlin](kotlinlang.org): Programming language
- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html): For building multi-platform applications in the single codebase.
- [Jetpack Compose/SwiftUi](https://developer.android.com/develop/ui/compose/documentation) (https://developer.apple.com/xcode/swiftui/): Build Native UI i.e. Android and iOS in this project.
- Kotlinx
  - [Coroutines](https://github.com/Kotlin/kotlinx.coroutines): For multithreading
  - [Serialization](https://github.com/Kotlin/kotlinx.serialization): For JSON serialization/deserailization
- [Ktor Client](https://github.com/ktorio/ktor): Performing HTTP requests.
- [Koin](https://github.com/InsertKoinIO/koin): A pragmatic lightweight dependency injection framework for Kotlin & Kotlin Multiplatform 
  
## Project structure 

This Compose Multiplatform project includes three modules:

### [`shared`](/shared)
This is a Kotlin module that contains the logic common for both Android and iOS applications, the code you share between platforms.
It uses Gradle as the build system. You can add dependencies and change settings in `shared/build.gradle.kts`. The shared module builds into an Android library and an iOS framework.

### [`androidApp`](/androidApp)
This is a Kotlin module that builds into an Android application. It uses Gradle as the build system. The `androidApp` module depends on and uses the shared module as a regular Android library.

### [`iosApp`](/iosApp)
This is an Xcode project that builds into an iOS application. It depends on and uses the shared module as a CocoaPods dependency.

---
## License

```
Copyright 2024 Ramarao Kotu

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
