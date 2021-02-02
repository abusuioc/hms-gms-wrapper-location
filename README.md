# Fused location made available immediately on both Google and Huawei mobile services

[![](https://jitpack.io/v/abusuioc/hms-gms-wrapper-location.svg?style=flat-square)](https://jitpack.io/#abusuioc/hms-gms-wrapper-location/)

In the beginning, the only fused location provider for Android devices was made available by Google Play Services.

FFW to late 2019 and we have a new player:  [Huawei](https://www.huawei.com/).

As part of the Huawei Mobile Services (aka HMS) offering, there is a new fused location provider called [Location Kit](https://developer.huawei.com/consumer/en/hms/huawei-locationkit).

Furthermore, because of the [US-China trade war](https://en.wikipedia.org/wiki/China%E2%80%93United_States_trade_war) , newer Huawei devices cannot be shipped with Google Play Services anymore. Therefore, the only way to have fused location services on those devices is to use the Location Kit.

So now you're thinking:

*"Great, but I have so many important things I wish to do in my codebase. Ain't nobody got time for another API to support ..."*

This is where this library comes in: **have a single location provider API that follows 1:1 the Google Play Services API and runs on top of both Google and Huawei implementations**.



## Advantages:

- implementation details are kept out of your codebase: you don't have to check which is the underlying provider and code for 2 APIs.

- gain support for the HMS location provider in maximum ***15 minutes*** of coding time in case you already have a working implementation based on Google Play Services location provider. 

- fresh start, need location? support both and code once.

- just build, run and you're done! ™

  

## How does it work under the hood?

First of all, it's not rocket science.

Huawei's Location Kit API is already very similar to Google's. After all, we're talking about the same functionality a user is expecting - why should the APIs be different? But then, classes & interfaces are (obviously) not really the very same, even if their exposed methods are so similar. Just compare the 2 `FusedLocationProviderClient`: [from Google Play](https://developers.google.com/android/reference/com/google/android/gms/location/FusedLocationProviderClient) / [from HMS version](https://developer.huawei.com/consumer/en/doc/development/HMS-References/fusedlocationproviderclient)  

The library follows 1:1 the Google Play Location provider's API structure & definitions . Sometimes it even enriches it with HMS specific goodies. It uses a mix of wrappers and interfaces. When the user has to instantiate a class or when there are public static methods in that class, then it's usually a wrapper that internally has both providers and it just delegates functionality to them. In the other cases, especially when the system creates the instances, a cleaner approach is used, based on interfaces that have then different implementations for each provider.

Already bored? Let's put this library to work.



## Usage

First things first: add the library as a dependency.

In your root `build.gradle` add [Jitpack](https://jitpack.io/) to the list of known repositories. Check that the Huawei and Google own repositories are there as well.

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
		maven { url 'https://developer.huawei.com/repo/' }
		google()
	}
}
```
Then add the actual library dependency in your app `build.gradle`:

```gradle
dependencies {
	implementation 'com.github.abusuioc:hms-gms-wrapper-location:1.0beta-5'
}
```



Now, depending on the current situation of your codebase, there are 2 scenarios:



##### 1. You already have a working implementation based on Google's fused location provider

STEP1: do a mass rename, essentially from package:

- `com.google.android.gms.location` to package:  `mobileservices.location`. 

Depending on your code and imports, you might need to touch other packages as well:

- `com.google.android.gms.tasks` -> `mobileservices.tasks`
- `com.google.android.gms.common` -> `mobileservices.common`

You can check that it was a successful rename by having no compilation errors at this point.

STEP2: pull the plug for the old Google Play Services Location provider direct dependency by removing the `implementation 'com.google.android.gms:play-services-location: ... '` entry from your app `build.gradle` .

Check again that there are no compilation errors.

STEP3: build, run and you're done! ™



##### 2. You wish to start fresh: new project, new implementation.

STEP1 (the only step really): use `mobileservices.location` as the default package for accessing the location API; you could use any tutorials from both Google or Huawei as a starting point for your implementation.

STEP2: build, run and you're done! ™



## Project status

The current beta covers the entire set of features except activity recognition and geofencing.

Please check out branch **feat/no-androidX** for a non AndroidX version.

Please reach out to me or create an issue to start a conversation. Thanks!