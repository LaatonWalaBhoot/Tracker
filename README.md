# Tracker
Tracking Phone Screen States in Real Time

Libraries Used:
1. Dagger2
2. Recycler View
3. RxJava2
4. Room

Architectural Choices
1. MVVM but I have removed the viewmodel because there was no business logic in the application apart from the polling
2. The polling status has been shifted to the EventReceiver
3. The EventListener is my contract between the receiver and the list which will dynamically update the view
4. Instead of keeping an instance of the list in the fragment. I have created an EVENT model which will update every single event separately. (A major reason behind not using the viewmodel)
5. The scoping for the Receiver has been set to @PerFragment just because only a single Activity is present in the entire app. Otherwise it would have been done on an Application Level.
6. The dependency of SimpleDateFormat is not done because its instance requires a different parsing logic and producing a single instance throughout the app would defeat its purpose.
7. The Service is sustained in Application scope
8. The Tracking service runs in a separate process to prevent it from closing down on app exit
9. The LiveData handling capabilities of the room database are used to update the list
10. The list received in the adapter is reversed to maintain the reverse chronology.
11. The listening capabilities have been shifted to the service from the fragment.
12. A separate receiver has been added to listen to stop service command from the notification itself.
13. 8. The database instance is available application wide to allow data transaction integrity


Future Prospects
1. Instead of updating the list perhaps a single event can be received from the db
2. Separate fragments using Viewpager for all three events.
3. Addition of date along with the time stamp.
4. Alarm Manager can be used to persist the service in the background on App exit

Working
1. The fragment sets the adapter which gets updated on receiving live data from the db
2. The service gets started along with the fragment on a separate process
3. The receiver listens for the events and calls the Event Listener which updates the db from the service
4. The event listener in turn updates the db and each event gets added as soon as it gets called.
5. The adapter and the receiver work simultaneously in cohesion with the db.
6. On first run of the Live Data observer the visibility of the list is changed.
7. The list is reversed and added to the db (Assumption: The list will remain small and can easily be reversed)
