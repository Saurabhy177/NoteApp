Clean Architecture Note App Code
==================================

This project has been developed with the help of youtube tutorial:<br>
https://www.youtube.com/watch?v=8YPXv7xKh2w&list=PLOf92TQmqSoj0XvDx38sUGS-fO5sEcqrA&index=5&t=7996s

Introduction
------------

NoteApp is designed using MVVM clean architecture using Jetpack Compose in a single module. <br>
Room DB is used for storing notes locally. <br>

This app contains three layers:<br>
a) <b>Data Layer:</b> This layer contains all the data related logic (databases, api calls and 
  implementations, etc).<br>
b) <b>Domain Layer:</b> This layer contains only the business logic.<br>
c) <b>Presentation Layer:</b> The layer contains all the UI logic and it is further divided into
  components. It contains the screens, states and view models. <br>

This app lets you:<br>
a) Add different colored notes locally on the device using Room DB.<br>
b) Edit and delete already created notes.<br>
c) Show list of created notes.<br>


Pre-requisites
--------------

You need to know:

* Building a basic user interface (UI) for an Android app, 
  using an activity, fragments, and views.
* Navigating between fragments and using Safe Args (a Gradle plugin) 
  to pass data between fragments.
* View models, flows and StateFlow and SharedFlow.
