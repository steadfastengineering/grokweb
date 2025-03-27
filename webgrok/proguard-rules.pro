# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#

## Required for using minify?
-dontwarn java.beans.BeanInfo
-dontwarn java.beans.FeatureDescriptor
-dontwarn java.beans.IntrospectionException
-dontwarn java.beans.Introspector
-dontwarn java.beans.PropertyDescriptor

# Experimental. These classes should be automatically retained? Why are we crashing? Stacktrace just says fatal.
#-keep class org.mozilla.geckoview.** { *; }
#-dontwarn org.mozilla.geckoview.**

# Protect potential JNI classes for libmagtsync.so
#-keep class com.steadfast.**.*magtsync* { *; }
#-keepclassmembers class com.steadfast.**.*magtsync* {
#    native <methods>;
#}
#
## GeckoView safety
#-keep class org.mozilla.geckoview.** { *; }
#-keepclassmembers class org.mozilla.geckoview.** {
#    native <methods>;
#}
#-dontwarn org.mozilla.geckoview.**
#
## General native method preservation
#-keepclasseswithmembers class * {
#    native <methods>;
#}

# Shrink, optimize, and obfuscate the code
-optimizationpasses 5
-dontusemixedcaseclassnames
