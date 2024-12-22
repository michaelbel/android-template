Android App Template
=

[![workflow-status](https://img.shields.io/github/actions/workflow/status/michaelbel/android-template/ci.yml?style=for-the-badge&logo=github&labelColor=3F464F)](https://github.com/michaelbel/android-template/actions)
[![last-commit](https://img.shields.io/github/last-commit/michaelbel/android-template?style=for-the-badge&logo=github&labelColor=3F464F)](https://github.com/michaelbel/android-template/commits)

This Android app template provides a foundation for quickly starting development across Mobile, Wear, TV, and Auto platforms. It includes pre-configured dependencies, code samples, and project structure, simplifying the creation and setup of new applications. The template helps reduce configuration time and allows developers to focus on implementing functionality, ensuring a smooth start.

[![android-phone](https://img.shields.io/badge/phone-000000.svg?style=for-the-badge&logo=android&logoColor=white)](https://github.com/michaelbel/android-template)
[![android-foldable](https://img.shields.io/badge/foldable-000000.svg?style=for-the-badge&logo=android&logoColor=white)](https://github.com/michaelbel/android-template)
[![android-tablet](https://img.shields.io/badge/tablet-000000.svg?style=for-the-badge&logo=android&logoColor=white)](https://github.com/michaelbel/android-template)
[![android-desktop](https://img.shields.io/badge/desktop-000000.svg?style=for-the-badge&logo=android&logoColor=white)](https://github.com/michaelbel/android-template)
[![android-wear](https://img.shields.io/badge/wear-000000.svg?style=for-the-badge&logo=android&logoColor=white)](https://github.com/michaelbel/android-template)
[![android-tv](https://img.shields.io/badge/tv-000000.svg?style=for-the-badge&logo=android&logoColor=white)](https://github.com/michaelbel/android-template)
[![android-auto](https://img.shields.io/badge/auto-000000.svg?style=for-the-badge&logo=android&logoColor=white)](https://github.com/michaelbel/android-template)
[![android-xr](https://img.shields.io/badge/xr-000000.svg?style=for-the-badge&logo=android&logoColor=white)](https://github.com/michaelbel/android-template)

**Phone (portrait)**
<div>
    <img src=".github/pics/phone-portrait.png" width="33%" alt="Phone portrait image">
    <img src=".github/pics/phone-portrait-details.png" width="33%" alt="Phone portrait image">
</div>
<br/>

**Phone (landscape)**
<div>
    <img src=".github/pics/phone-landscape.png" width="66%" alt="Phone landscape image">
    <img src=".github/pics/phone-landscape-details.png" width="66%" alt="Phone landscape image">
</div>
<br/>

**Foldable**
<div>
    <img src=".github/pics/foldable.png" width="66%" alt="Foldable Image">
</div>
<br/>

**Tablet (portrait)**
<div>
    <img src=".github/pics/tablet-portrait.png" width="48%" alt="Tablet portrait image">
    <img src=".github/pics/tablet-portrait-details.png" width="48%" alt="Tablet portrait image">
</div>
<br/>

**Tablet (landscape)**
<div>
    <img src=".github/pics/tablet-landscape.png" width="74%" alt="Tablet landscape image">
    <img src=".github/pics/tablet-landscape-details.png" width="74%" alt="Tablet landscape image">
</div>
<br/>

**Desktop**
<div>
    <img src=".github/pics/desktop.png" width="99%" alt="Desktop Image">
</div>
<br/>

**Wear OS**
<div>
    <img src=".github/pics/wearos.png" width="33%" alt="WearOS Image">
    <img src=".github/pics/wearos-details.png" width="33%" alt="WearOS Image">
</div>
<br/>

**TV**
<div>
    <img src=".github/pics/tv.png" width="99%" alt="TV Image">
</div>
<br/>

**Automotive**
<div>
    <img src=".github/pics/automotive.png" width="66%" alt="Automotive Image">
</div>
<br/>

**XR**
<div>
    <img src=".github/pics/xr.png" width="99%" alt="XR Image">
</div>

## Features
- [x] Included all Kotlin dependencies
- [x] Included all Google Play Services dependencies
- [x] Included all Google Play dependencies
- [x] Included all Google Material dependencies
- [x] Included all Google Horologist dependencies
- [x] Included all Google MLKit dependencies
- [x] Included all Firebase dependencies
- [x] Included all AndroidX dependencies
- [x] Included all popular third-party dependencies
- [x] Pre-built implementations:
    - [x] Koin
    - [x] Ktor
    - [x] Room
    - [x] DataStore
    - [x] Repository
    - [x] Interactor

## Configure
* In the current `readme.md` file, update the project name, badges, description, and screenshot.
* In `settings.gradle.kts`, update `rootProject.name`.
* Rename the application package.
* In the `build.gradle` file of the core module, update the `namespace`.
* In the `build.gradle` file of the app module, update the `namespace`, `applicationId`, and `archivesName`. If a release version is needed, add a `keystore.properties` file in the `config` directory.
* In `strings.xml`, update `app_name`.