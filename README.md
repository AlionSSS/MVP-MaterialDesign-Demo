# MVP-MaterialDesign-Demo
这是一个MVP框架 + Google Material Design的示例

## 说明
- 图形设计、及相关材料来源于《第一行代码》
- 本项目将原项目的框架改为了MVP，重新制作
- 本项目做了一些MaterialDesign的补充效果实现

## 内容
- MVP
    - Model
    - View
    - Presenter
    - Interactor
- Material Design
    - CoordinatorLayout
    - AppBarLayout
    - Toolbar
    - SwipeRefreshLayout
    - RecyclerView
    - FloatingActionButton
    - NavigationView
    - CollapsingToolbarLayout
    - NestedScrollView
    - CardView
    - ActionBarDrawerToggle
    - ActivityOptions.makeSceneTransitionAnimation

## build.gradle
```gradle
apply plugin: 'com.android.application'

android {
    compileSdkVersion 24
    buildToolsVersion "25.0.2"
    defaultConfig {
        applicationId "com.example.materialtest"
        minSdkVersion 15
        targetSdkVersion 24
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:24.2.1'
    compile 'com.android.support:design:24.2.1'
    compile 'com.android.support:cardview-v7:24.2.1'
    compile 'com.android.support:recyclerview-v7:24.2.1'
    compile 'com.android.support.constraint:constraint-layout:1.0.2'
    compile 'de.hdodenhof:circleimageview:2.1.0'
    compile 'com.github.bumptech.glide:glide:3.7.0'
    testCompile 'junit:junit:4.12'
}
```
