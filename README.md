# LoadingDialog
封装Android LoadingDialog

## 效果展示
<img src="https://github.com/shenbengit/LoadingDialog/blob/master/screenshots/LoadingDialog.gif" alt="动图演示效果" width="250px">

## 引入

### 将JitPack存储库添加到您的项目中(项目根目录下build.gradle文件)
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
### 添加依赖
[![](https://jitpack.io/v/shenbengit/LoadingDialog.svg)](https://jitpack.io/#shenbengit/LoadingDialog)
```gradle
dependencies {
    implementation 'com.github.shenbengit:LoadingDialog:Tag'
}
```

## 使用事例

```kotlin
// 创建自定义LoadingDialog
val loadingDialog = LoadingDialog.Builder(context, R.style.LoadingDialog)
            .setCancelable(false)//[Dialog.setCancelable]
            .setCanceledOnTouchOutside(false)//[Dialog.setCanceledOnTouchOutside]
            .setHintText("加载中...")//设置显示的提示性文字内容
            .showHintText(true)//是否显示提示性文字
            .create()
            
 //显示dialog
 loadingDialog.show()
 //隐藏dialog
 loadingDialog.dismiss()//or loadingDialog.cancel()
 
 //快速创建默认配置的LoadingDialog
val defaultLoadingDialog1 = LoadingDialog.createDefault(context)
val defaultLoadingDialog2 = LoadingDialog.createDefault(context, R.style.LoadingDialog)
```

# [License](https://github.com/shenbengit/LoadingDialog/blob/master/LICENSE)
