# Store_App

App GIF
--------------
<p align="center">
  <img src="https://raw.githubusercontent.com/kocerenes/Store_App/master/gif/storeapp.gif" alt="GIF" />
</p>
 
 Libraries Used
--------------
* [Architecture][10] - Start with classes for managing your UI component lifecycle and handling data
  persistence.
  * [Lifecycles][12] - Create a UI that automatically responds to lifecycle events.
  * [Repository][18] - Repository modules handle data operations.
  * [ViewModel][17] - Easily schedule asynchronous tasks for optimal execution.
  * [coroutines][11] A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
  * [flow][91] Flows are built on top of coroutines and can provide multiple values. A flow is conceptually a stream of data that can be computed asynchronously. 
* [UI][30] - Details on why and how to use UI Components in your apps - together or separate
  * [Jetpack Compose][34] - A basic unit of composable UI.
* Third party and miscellaneous libraries
  * [Retrofit][90] for turns your HTTP API into a Java interface
  * [Dagger-Hilt][93] Hilt is the recommended solution for dependency injection in Android apps, and works seamlessly with Compose.
  * [Coil][92] for image loading
  
  
[10]: https://developer.android.com/jetpack/compose/architecture
[11]: https://developer.android.com/kotlin/coroutines#:~:text=A%20coroutine%20is%20a%20concurrency,established%20concepts%20from%20other%20languages.
[12]: https://developer.android.com/jetpack/compose/lifecycle
[17]: https://developer.android.com/jetpack/compose/state#viewmodel-state
[18]: https://developer.android.com/jetpack/guide#fetch-data
[30]: https://developer.android.com/jetpack/compose/tutorial
[34]: https://developer.android.com/jetpack/compose
[90]: https://square.github.io/retrofit/
[91]: https://developer.android.com/kotlin/flow
[92]: https://coil-kt.github.io/coil/compose/
[93]: https://developer.android.com/jetpack/compose/libraries#hilt
 
