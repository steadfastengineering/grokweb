# Grokweb
A simple `webview` display of Grok's web application. "Tinfoil" for Grok if you will. This was done
to port access to Grok to Android devices which aren't able to install the official Grok app.  
Built in Kotlin with Jetpack and Compose.  

### TODOs:
1. Handle navigation to and from the app correctly so state is preserved in the view. 
2. Populate info button. 
3. Fix AOSP `webview` bug for those without Gapps or those running AOSP ROMS have access.

### Bugs: 
- AOSP based ROMs have problems loading, resulting in `ERR_INTERNET_DISCONNECTED`. 

### License
This project is licensed under the MIT License.