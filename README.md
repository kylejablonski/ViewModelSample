# ViewModelSample
Sample application showing the usage of LiveData and ViewModel from Architecture Components

My blog post details the basics of LiveData and ViewModel:

# Using ViewModel and LiveData in your Android App

## A common trap
Since the dawn of Android, application development has been a bit like the wild west. As developers, we want 
to build fast so sometimes we neglect the architectural design of our applications from the start. A designer 
hands off the UI and we go over the requirements for our project and start building. The MainActivity starts 
out lean but we create a bunch of objects for our business logic, hook into framework API's to start services or 
leverage hardware from the device resulting in a 2K line file and error-prone code. But we can do much better by 
taking some extra time to think about separation of concerns within our application. The applications we are 
building should be modular, extensible and testable. So how do we accomplish this in GUI applications?

Loaded answer: developing an architecture for the application!

<a href="https://goo.gl/UHfCGA">Continue reading </a>
