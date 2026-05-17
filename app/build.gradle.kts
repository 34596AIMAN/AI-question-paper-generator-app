plugins {
alias(libs.plugins.android.application)
}

android {
namespace = "com.myapp.aiqpg"
compileSdk = 35

defaultConfig {
    applicationId = "com.myapp.aiqpg"
    minSdk = 24
    targetSdk = 35
    versionCode = 1
    versionName = "1.0"
}

buildTypes {
    release {
        isMinifyEnabled = false
        signingConfig = signingConfigs.getByName("debug")
        proguardFiles(
            getDefaultProguardFile("proguard-android-optimize.txt"),
            "proguard-rules.pro"
        )
    }
}

compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
}

dependencies {
implementation("androidx.appcompat:appcompat:1.6.1")
implementation("com.google.android.material:material:1.11.0")
implementation("androidx.constraintlayout:constraintlayout:2.1.4")
implementation("androidx.recyclerview:recyclerview:1.3.2")
implementation("androidx.cardview:cardview:1.0.0")
implementation("androidx.lifecycle:lifecycle-livedata:2.7.0")
implementation("androidx.lifecycle:lifecycle-viewmodel:2.7.0")
implementation("androidx.activity:activity:1.8.2")
implementation("androidx.fragment:fragment:1.6.2")

// Room
implementation("androidx.room:room-runtime:2.6.1")
annotationProcessor("androidx.room:room-compiler:2.6.1")

// Retrofit
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")

// OkHttp
implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

// Testing
testImplementation("junit:junit:4.13.2")
androidTestImplementation("androidx.test.ext:junit:1.1.5")
androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
