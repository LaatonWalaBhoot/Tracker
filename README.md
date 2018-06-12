# Tracker
Tracking Phone Screen States in Real Time

Libraries Used:
1. Dagger2
2. Recycler View

Architectural Choices
1. MVVM but I have removed the viewmodel because there was no business logic in the application apart from the polling
2. The polling status has been shifted to the EventReciever 
3. The EventListener is my contract between the reciever and the list which will dyanamically update the view
4. Instead of keeping an instance of the list in the fragment. I have created an EVENT model which will update every single event separately. (A major reason behind not using the viewmodel)
5. The scoping for the Reciever has been set to @PerFragment just because only a single Activity is present in the entire app. Otherwise it would have been done on an Application Level.
6. The dependency of SimpleDateFormat is not done because its instance requires a diffrent parsing logic and producing a single instance throughout the app would defeat its purpose.

Future Prospects
1. A DB implementation can be done to save the list and add it on resuming the application. Perhaps I can have a go at ROOM libary or REALM
2. Separate fragments using Viewpager for all three events.
3. Background service to display tracking.
4. Addition of date along with the time stamp.

Working
1. The fragemnt registers the receiver and initializes an empty list.
2. The reciever listens for the events and call the contract EventListener 
3. The event listener in turn updates the list and each event gets added as soon as it gets called.
4. The adpater and the reciever work simulataneously in cohesion with the view that is the fragment.
5. The event listener is the crowned jewel which enables simple transmission of events to the adapter without having to instantiate or pass a collection.
6. Each item gets added to the top of the list.
