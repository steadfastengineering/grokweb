# Grokweb
A simple display of Grok's mobile web application. "Tinfoil" for Grok if you will. This was done
to port access to Grok to Android devices which aren't able to install the official Grok app, or
those who may want to access it in a different way.

### Under the hood
The application uses Mozilla's `geckoview` to package the webpage and manage state. This ensures
better compatability as the application contains a full runtime from Mozilla rather than rendering 
the web page via whichever installed `webview` a user may be stuck with on their system. 

### Privacy
No data is collected by this application. Any interaction with the underlying website is between
the user and the website. 

### TODOs:
- Populate info button. 

### Bugs: 
- None right now, testing required

### License
This project is licensed under the MIT License.
