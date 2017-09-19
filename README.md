# StackoverflowUser
This app retrieves and displays the first page of Stackoverflow users. The example aims to be as close to production-ready-app as possible and it demonstrates various aspect of Android Design Patterns and provides an example of how each component interacts and communicates with eachother.

## Get Started:
- Clone the project
- Import to Android Studio
- Compile and install to Android Emulator or Android devices with developer option enabled

## Additional Informations:
### MVC/MVP/MVVM debate
Hmmm... I believe any one who develops on Android platform will ask the same question at some point:
```
Is Activity/Fragment a view or a controller?
```
In Android, Activity/Fragment can act both as View and Controller from a different angle and we can all agree that it is rather confusing. Using correct architecture pattern will simplify the answer. 
 
This app uses MVP architecture pattern. Over the years of using all three architecture patterns, I find that MVP is good for Android development and MVVM is a good design for iOS app, which corresponding to the popularity of MVP among Android developers and MVVM among iOS developers.

#### Why not MVC?
MVP, in my opinion, is better for Android development because it decouples the View and the Model components which makes the app easy testable. Models and Views should not take over the resposibility of other component. In MVC, for example, views can have logic in them to communicate with Model and Model can have logic to communicate with View. In constrast, in MVP, Views only handle UI, Models only store data, and Presenters act as a middle men to connect between the UI and data.

#### Why not MVVM?
MVVM is a very good pattern and it works nicely with reactive programming. My experience with MVVM comes from developing iOS app. I will take MVVM into consideration for further project.

### Access Token:
Stackoverflow API requires an access token to get over the call limit for a single IP address. This project does not contain an access token so it is subjected to 300 call limits.

### Jack Compiler:
Jack Compiler is used in the project. I use it for ease of access to Java 8 without the need to add Retrolambda (required additional plugin). It will be deprecated in future version of Android Studio but Java 8 will also be natively supported so migrating from Jack Compiler is as easy as removing
```
jackOptions {
            enabled true
        }
```

### Third-party libraries:
- Retrofit & OkHttp: Handle all networking and caching. It also works with RxJava and Gson
- Glide: Loading and Caching Image. I specifically chose Glide over Picasso because it supports GIF. Fresco also supports gif but it is rather heavy.
- RxJava: Reactive programming. It also allows easy multi-threading with Schedulers
- Butterknife: View binding, remove findViewById boiler plate codes

## License - MIT License

Copyright (c) 2017 Vincent Ngo

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
