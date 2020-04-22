# PokeApp

This application was developed using the guidelines below:

(as much as possible considering the dev experience)

- Clean Architecture 
- S.O.L.I.D Principles
- Multimodular Application
- MVVM 

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
- RxJava (reactive)
- Retrofit and OKHTTP (network requests)
- Koin (dependency injection)
- Kotlin serialization (JSON serialization)
- Live Data and ViewModel (ui state management)

Possible improvements: 

- UI/Unit tests
- Add data persistence (with RoomDB Library, for example)
- Better implementation of class UsecaseInterface to remove refresh attribute

