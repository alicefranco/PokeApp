# PokeApp

Versions:

Android Studio: Hedgedhog | 2023.1.1 Patch 2

Gradle Wrapper: 8.5

Kotlin Plugin: 1.9.22

Android Gradle Plugin: 8.2.2


This application was developed using the guidelines below:

(as much as possible considering the dev experience)

- Clean Architecture 
- S.O.L.I.D Principles
- Multimodular Application
- MVVM 
- Unit Tests

The multimodular architecture was organized with one module per feature, containing its domain, data and presentation.	This division were used if more scalability is needed, as it can be the case, for example, of adding details for Abilities and Moves. For each new feature added, a new module will be added as well.

Features don't depend on each other, depend only on shared modules which are shared-domain and shared-network. 
Shared-domain and shared-network are independent modules which are used for a standard interface accross
all features domains and network requests, respectively.
There is also app module which holds whole application, and depends on all the other modules. 

Dependencies are showed bellow:

- app
  - feature-pokelist 
    - shared-domain
    - shared-network
  - shared-network
  - shared-domain
  
MVVM architecture were used to separate the concerns between the presentation and data. 
All activities (VIEW) only hold presentation information, all repositories hold the data (MODEL) and know nothing about activities, all viewmodels (VIEWMODEL) deal with the interaction between activities and repositories.

The following libraries were used: 

- Flow (reactive)
- Retrofit and OKHTTP (network requests)
- Hilt (dependency injection)
- ViewModel (UI state management)
- Compose (UI)

Possible improvements: 

- UI tests
- Better test coverage
- Add data persistence (with RoomDB Library, for example)
- Get list image resources directly from github https://github.com/PokeAPI/sprites
- Better implementation of class UsecaseInterface to remove refresh attribute
- Add git action to run lint before commit
- Configure proguard

Refactoring:

- Add pokemon list pagination
- Remove mocks in pokemon details screen
- Uncomment tests

Planned new features:
- Add login with Firebase
- Save favorites



