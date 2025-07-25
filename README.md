# 🚀 MySystem-Design

A curated list of system design case studies and class entities cheatsheet implemented with **Java**, focusing on OOP principles and design patterns.

---

## 📋 Content
1.  Design **Parking Lot** System                     `#Singleton #Strategy #Factory`
2.  Design **Stack Overflow**                         `#Observer #Decorator #Strategy`
3.  Design a **Vending Machine**                      `#State #Strategy #Singleton`
4.  Design **Logging Framework**                      `#Singleton #Strategy #ChainOfResponsibility`
5.  Design **Traffic Signal Control** System          `#State #Observer #Command`
6.  Design coffee Vending Machine                 `#Singleton #Strategy #Builder`
7.  Design a Task Management System               `#Observer #Composite #Factory`
8.  Design **ATM**                                    `#State #Strategy #Factory`
9.  Design **LinkedIn**                               `#Observer #Builder #Factory`
10. Design **LR**U Cache                              `#Strategy`
11. Design **Tic Tac Toe** Game                       `#Singleton #Strategy`
12. Design **Pub Sub** System                         `#Observer #ProducerConsumer`
13. Design an **Elevator** System                     `#State #Command #Strategy`
14. Design **Car Rental** System                      `#Singleton #Factory #Strategy`
15. Design an **Online Auction** System               `#Observer #Factory #Strategy`
16. Design **Hotel Management** System                `#Singleton #State #Factory`
17. Design a **Digital Wallet** Service               `#Strategy #Factory`
18. Design **Airline** Management System              `#Strategy #Factory #Observer`
19. Design a Library Management System            `#Factory #Strategy #Observer`
20. Design a Social Network - **Facebook**         `#Observer #Builder #Strategy`
21. Design Restaurant Management System           `#Factory #Observer #Strategy`
22. Design a Concert Ticket Booking System        `#Strategy #Factory #Observer`
23. Design **CricInfo**                               `#Observer #Strategy #Factory`
24. Design **Splitwise**                              `#Strategy #Observer #Factory`
25. Design **Chess** Game                             `#State #Strategy`
26. Design a **Snake and Ladder** Game                `#Builder #Strategy`
27. Design Ride‑Sharing Service like - **Uber**         `#Strategy #Observer #GeoHashing`
28. Design Course Registration System             `#Factory #Strategy #Observer`
29. Design Movie Ticket Booking System - **BookMyShow**            `#Singleton #Strategy #Observer`
30. Design Online Shopping System - **Amazon**     `#Strategy #Factory #Observer`
31. Design Online Stock Brokerage System - **Grow**          `#Factory #Strategy #Observer`
32. Design Music Streaming Service - **Spotify**   `#Observer #Caching #Strategy`
33. Design Online Food Delivery Service - **Zomato** `#Strategy #Factory #Observer`

To be continued....

xx. Design **URL Shortener**  
xx. Design **Rate Limiter** (e.g., Token Bucket)  
xx. Design Inventory Management System  
xx. Design **Notification System ** 
xx. Design Text Editor with Formatting  
xx. Design In-Memory Virtual File System  
xx. Design Chat Application  
xx. Design Recipe Manager  
xx. Design Bank Account Class  
xx. Design Mini File Sharing App (mini-Dropbox)  
xx. Design Auto-Complete Feature (search suggestions)  
xx. Design Key-Value Data Store (cache)  
xx. Design Banking Notification/Alert System  
xx. Design Board/Card Game (Poker/Boggle)  
xx. Design Email Service or Mailing System  
xx. Design CRM Ticket/Issue Assignment System  
xx. Design Wi-Fi Hotspot Manager Class  
xx. Design Meeting Room Scheduler (multiple time slots)  
xx. Design Poll/Voting System with tally and options  
xx. Design Quiz/Test with Question-Bank Class  
xx. Design File Upload Manager (chunking, progress)  
xx. Design Workflows like Order → Ship → Invoice  
xx. Design Delegation Chain for Admin Rights  
xx. Design Remote Worker Attendance Tracker  
xx. Design Email Threading / Conversation Model  
xx. Design Kanban Board (Lists & Cards)  
xx. Design Download Manager (pause/resume logic)  
xx. Design Dynamic Pricing (offers, discounts)  
xx. Design News Feed Ranking System (social app)  
xx. Design File Compression/Decompression Class  
xx. Design Multi-currency Wallet Conversion Logic  
xx. Design OTP Generator & Validator  


## Design Patterns
1. Design Parking Lot System  
`#Singleton - ParkingLotManager`  
`#Strategy - FeeCalculation`  
`#Factory - VehicleType SpotFactory`  

2. Design Stack Overflow  
`#Observer - Notifications`  
`#Decorator - Badge System`  
`#Strategy - SearchRanking`  

3. Design a Vending Machine  
`#State - MachineState (Idle, Dispense)`  
`#Strategy - PricingPolicy`  
`#Singleton - MachineController`  

4. Design Logging Framework  
`#Singleton - Logger Instance`  
`#Strategy - LogOutput (Console/File/Remote)`  
`#ChainOfResponsibility - Log Filters`  

5. Design Traffic Signal Control System  
`#State - Signal States (Red/Green)`  
`#Observer - Pedestrian/Vehicle Sensors`  
`#Command - LightChangeScheduler`  

6. Design Coffee Vending Machine  
`#Builder - Drink Creation (Espresso, Latte)`  
`#State - BrewingState`  
`#Singleton - VendingController`  

7. Design a Task Management System  
`#Composite - Tasks/Subtasks`  
`#Observer - Status Update Notifications`  
`#Factory - TaskObject Creation`  

8. Design ATM  
`#State - ATMMode (InsertCard, Withdraw)`  
`#Strategy - TransactionType`  
`#Factory - CardTypeFactory`  

9. Design LinkedIn  
`#Observer - Feed Updates`  
`#Builder - Profile Creation`  
`#Factory - Post/Connection Objects`  

10. Design LRU Cache  
`#Strategy - EvictionPolicy (LRU/FIFO)`  

11. Design Tic Tac Toe Game  
`#Singleton - GameController`  
`#Strategy - WinChecker`  

12. Design Pub Sub System  
`#Observer - Topic Subscriptions`  
`#ProducerConsumer - Message Queue Handling`  

13. Design an Elevator System  
`#State - ElevatorState (Idle, Moving)`  
`#Command - FloorRequests`  
`#Strategy - SchedulingAlgorithm (FCFS/SCAN)`  

14. Design Car Rental System  
`#Singleton - RentalServiceManager`  
`#Factory - Vehicle/Plan Creation`  
`#Strategy - PricingEngine`  

15. Design an Online Auction System  
`#Observer - Bidder Notifications`  
`#Strategy - BiddingStrategy (Auto/Manual)`  
`#Factory - AuctionType`  

16. Design Hotel Management System  
`#Singleton - BookingManager`  
`#State - RoomStatus (Available/Booked)`  
`#Factory - Room/Service Factory`  

17. Design a Digital Wallet Service  
`#Strategy - PaymentMethod (UPI, Card)`  
`#Factory - WalletFactory`  

18. Design Airline Management System  
`#Factory - Flight/Ticket Creation`  
`#Observer - Flight Updates`  
`#Strategy - Fare Calculation`  

19. Design a Library Management System  
`#Factory - Book/Member Creation`  
`#Observer - Due Notifications`  
`#Strategy - Fine Calculation`  

20. Design a Social Network like Facebook  
`#Observer - Feed/Notification System`  
`#Builder - Profile/Group Creation`  
`#Strategy - PostRanking`  

21. Design Restaurant Management System  
`#Factory - Menu Item Creation`  
`#Observer - Order Notifications`  
`#Strategy - Order Assignment`  

22. Design a Concert Ticket Booking System  
`#Strategy - Seat Allocation`  
`#Factory - Ticket/Customer Object`  
`#Observer - Booking Notifications`  

23. Design CricInfo  
`#Observer - Live Match Updates`  
`#Factory - Player/Match/Event Factory`  
`#Strategy - Score Calculation`  

24. Design Splitwise  
`#Strategy - ExpenseSplitting`  
`#Observer - Payment Status Updates`  
`#Factory - User/Group Factory`  

25. Design Chess Game  
`#State - GameState (Turn/End)`  
`#Strategy - MoveValidator`  
`#Factory - PieceFactory`  

26. Design a Snake and Ladder Game  
`#Builder - Board Setup`  
`#Strategy - DiceRoll`  
`#Factory - Snake/Ladder Factory`  

27. Design Ride‑Sharing Service like Uber  
`#Strategy - DriverMatching`  
`#Observer - Trip Updates`  
`#GeoHashing - Proximity Search`  

28. Design Course Registration System  
`#Factory - Course/User/Session`  
`#Observer - Enrollment Alerts`  
`#Strategy - TimeConflictResolver`  

29. Design Movie Ticket Booking System  
`#Singleton - BookingManager`  
`#Strategy - SeatSelection`  
`#Observer - Notification System`  

30. Design Online Shopping System like Amazon  
`#Strategy - Payment/DeliveryOptions`  
`#Factory - Product/Cart Creation`  
`#Observer - Order Tracking`  

31. Design Online Stock Brokerage System  
`#Strategy - OrderExecution`  
`#Observer - Price Updates`  
`#Factory - PortfolioFactory`  

32. Design Music Streaming Service like Spotify  
`#Observer - Playlist/Recommendation Updates`  
`#Strategy - StreamingQuality`  
`#Caching - Popular Tracks`  

33. Design Online Food Delivery Service like Swiggy  
`#Strategy - DeliveryAssignment`  
`#Factory - Order/Restaurant/UserFactory`  
`#Observer - Real-Time Tracking`  




---

## ALL LLD Class Entities

```java
1. Design Parking Lot
ParkingLot
ParkingLevel
ParkingSpot
<<Vehicle>> Bike Car
VehicleType
Ticket
<<FeeCalculationStrat>> IndividualStrat FixedStrat
----------------------
Singleton
Strategy
Factory

======================================================================

2. Design StackOverflow
StackOverflow
User
Questions
Answers
Comments
Votes
Enum Tags
SearchStratgey
------------------
Strategy Pattern: For voting and commenting behaviors via interfaces.
Observer Pattern: (Conceptually) for reputation updates on votes and accepted answers.

======================================================================

3. Designing a Vending Machine
Vending Machine
I-Product (Books, pen)
Coins
Notes
Inventory
I-VendingMachineState ( IdleState, ReadyState, and DispenseState)
-------------------
Singleton
State Pattern: For managing machine states and transitions.

======================================================================

4. Design Logging System
E - Level
Message
I - LogAppender/Destination
ConsoleAppender
FileAppender
DatabaseAppender
LogConfig (Level, Destination)
Logger
-----------------
Singleton
Strategy Pattern: For interchangeable log formatters and appenders.
Singleton Pattern: (If used) For global logger instance.
Factory Pattern: (Optional) For creating appenders/formatters based on config.
Observer Pattern: (Conceptually, for notifying multiple appenders.)

======================================================================

5. Traffic Signal System 

======================================================================

6. Coffee Vending Machine
CoffeeVendingMachine
CoffeeRecipe -  Represents a coffee recipe, including required ingredients and their quantities.
IngredientStore - inventory of ingredients, supports checking and refilling.
Dispensor -  Handles the dispensing of coffee after successful payment and ingredient check
PaymentProcessor - Handles payment logic and validation.
Payment - Represents a payment transaction.
-------------------------
Singleton
Strategy Pattern: (Conceptually) for supporting different payment methods or coffee recipes.
Separation of Concerns: Each class has a single responsibility (inventory, payment, dispensing, etc.).

======================================================================

7.Design Task Managment System
Task: Represents a task with title, description, status, priority, assignee, and comments.
User: Represents a user who can create, assign, and be assigned tasks.
Comment: Represents a comment on a task.
TaskStatus: Enum for task statuses (TODO, IN_PROGRESS, DONE, etc.).
TaskPriority: Enum for task priorities (LOW, MEDIUM, HIGH).
TaskManager: Manages the collection of tasks and provides methods for task operations.
---------------------------------
Separation of Concerns: Each class has a single responsibility (task, user, comment, management).
Manager Pattern: TaskManager acts as a service/manager for all task operations.

======================================================================

8. Design an ATM System
ATM
Card
Account
BankingService
<Transaction>
WithdrawalTransaction
DepositTransaction
CashDispenser
----------------------
Add mini-statements: Show recent transactions.
Add fund transfers: Allow transfers between accounts.
Add multi-currency support: Handle different currencies and conversions.

======================================================================

9. Design LinkedIn
LinkedIn
User
Profile
JobPosting
Message
Notification
NotificationType
NotificationObserver
NotificationSubject
------------------------
Singleton
Factory
Observer - Notifications
Strategy - ( todo - feed )

======================================================================

10. Design LRU Cache
Cache: Main class implementing the cache logic, manages storage and eviction.
Node: Represents a doubly-linked list node for fast removal and insertion.
I<EvictionPolicy> - stratgey design pattern for using any diff logic for cache ex: LRU
LRUEvictionPolicy
-----------------------
Strategy
Doubly Linked List: For O(1) removal and insertion of nodes.
Hash Map: For O(1) access to nodes by key.
Separation of Concerns: Node and cache logic are separated.

======================================================================

11. Design a Tic Tac Toe
Game: Manages the game flow, player turns, and game status.
Board: Represents the NxN grid and provides methods to update and check the board.
Cell: Represents a single cell on the board.
Player: Represents a player with a name and symbol.
Symbol: Enum for X and O.
GameStatus: Enum for IN_PROGRESS, DRAW, WIN.
GameState
Game Context
--------------------
Singleton

======================================================================

12. Design Pub Hub
Topic
Message
Publisher ->
Broker ->

Dispatcher
Subscriber ->
-------------
Observer Pattern: 

======================================================================

13. Design an Elevator System
@ Elevator - int id, currFloor, capacity, direction, requests, isMoving
--
@ ElevatorController -
requestElevator(source , destination)
findOptimalElevator(source , destination)
step()

@ Request- floor, direction

@ E<Direction>- UP DOWN IDLE
-----------------

======================================================================

14. Design Car Rental System
@RentalSystem
@RentalStore
@User
@Reservation
@ReservationManager

----- abstract ----
@VehicleFactory
@A<Vehicle>
EconomyVehicle
SuvVehicle
LuxuryVehicle

--- strategy ----
@PaymentProcessor
@I<PaymentStrategy>
CashPayment
CreditCardPayment

--- Enum state management ----
@VehicleStatus
@VehicleType
@ReservationStatus
------------------
Singleton

======================================================================

15. Design Online Auction System
@AuctionSystem - users, items, auctionListings

@User - username, email, placedAuctions

@AuctionListing - id, name, startingBid, highestBid, auctionStatus, winner

@Item - name, description

@Bid - id, bidder, amount, time

#Enums
@AuctionStatus- OPEN BIDDING CLOSE
--------------

======================================================================


16. Design Hotel management system 
@HotelManagementSystem - instance guests, rooms, reservations <-  Singleton Design pattern
@Guest - id, name, email, number
@Room - id, price, roomType, roomStatus
@Reservation - id, guest, room, checkIn, checkOut, reservationStatus

@PaymentProcessor  - paymentStrategy  <-  State Design pattern
@I<PaymentStrategy> - processPayment()

--- Enums State Management ---
@RoomType -  SINGLE, DOUBLE, SUITE <- or Factory Design pattern
@RoomStatus - AVAILABLE, OCCUPIED, CLEANING, MAINTENANCE
@ReservationStatus  - PENDING, CONFIRMED, CANCELLED, COMPLETED

-------------

======================================================================

17. Digital Wallet Service
@DigitalWallet - instance

@User - id, name, email, pass, accounts,  List<Account>
@Account - id, user, accountNumber,currency, balance, List<> transactions 
@BankAccount - accountNumber, routingNumber, paymentStrategy 
@CreditCard - cardNumber, expirationDate, CVV
@Transaction - id , sourceAccount ,destinationAccount ,amount ,currency ,timestamp

@PaymentHandler
@PaymentStrategy

@CurrencyConverter - Map<Currency, BigDecimal> exchangeRates, convert 

@E<Currency> USD EUR
GBP
JPY
-----------------------------

======================================================================

18. Design Airline Management System

@Aircraft - tailNumber, model, totalSeats

@Passenger - id, name, email

@Booking - id , Flight, Passenger, Seat, price, Status [ cancel() ] 
@BookingManager - instance, <>Booking , lock [ createBooking() cancelBooking() ]
@BookingStatus 

@Flight - flightNumber, source, dest, departTime, arrivTime, status, Aircraft, <>seats
@FlightSearch - <>flights, [ addFlight(), searchFlightByKeyword() ]
@FlightStatus

@Seat - seatNumber, type, status
@SeatType - ECONOMY, PREMIUM_ECONOMY, BUSINESS, FIRST_CLASS
@SeatStatus

@Payment             <---------- Strategy
@PaymentProcessor  
@PaymentStatus 

@AirlineManagementSystem - flights, aircraft, passengers, flightSearch, bookingManager, paymentProcessor
[addPassenger(), addAircraft(), addFlight(), searchFlight(), cancelBooking(), processPayement() ]

======================================================================

19. Design Library Management System
@Book - isbn, title, author
@BookCopy - Book, barcode, BookStatus
@BookStatus - AVAILABLE, BORROWED, RESERVED, LOST

@Member - id, name, contactInfo, <>Loans
@Loan- id, BookCopy, Member, borrowDate, dueDate, isActive ,MAX_BORROW_DAYS

@Catalog - <>bookCopiesbyBarcod, <>byTitle, <>byAuthor, <>byIsbn, 
[addInAllCopies(), getBookCopiesByTitle(), getBookCopyByBarcode(), 
searchByTitle(), searchByAuthor(), searchByIsbn()]

@LibraryManagementSystem - instance, CataLog, <>Books, <>Members, <>Loans, MAX_BOOKS_PER_MEMBER
[addBookCopy(), registerMember(), borrowBook(), returnBook(), searchByTitle(), searchByAuthor()]

======================================================================

20. Design Social Networking like FaceBook
@User - id, name , email, password, bio, <>Friends, <>PostMap, <>FriendRequests, <>Notifications 
[addFriend(), addPost(), receiveRequest(), getRequestFrom(), addNotification()]
@Post - id, User, content, timestamp, <>UserIdLikeMap, <>Comments;
@Comment - id, user, text, timestamp [like(), comment()]
@Like - User, timeStamp
@FriendRequest - from , to, FriendRequestStatus
@FriendRequestStatus - PENDING, ACCEPTED, REJECTED

<-------- Observer pattern
@Notification - id , User, NotificationTyp , content, timestamp;
@NotificationType - FRIEND_REQUEST FRIEND_REQUEST_ACCEPTED, LIKE, COMMENT, MENTION

@SocialNetworkingService - instance, <>UsersMap, <>PostsMap
[registerUser(), login(), sendFriendRequest(), acceptFriendRequest(), 
createPost(), likePost(), commentOnPost(), getNewsFeed(userId)]

======================================================================

21. Design Restaurant Management System
@Staff - id, name, role, contactNumber
@Table - id, capacity, isReserved [reserve(), release(0, isBooked()]

@MenuItem - name, price, avaiable
@OrderItem - MenuItem, quantity
@Order - id, <>OrderItems, OrderStatus, table [setOrderStatus(), calculateTotal()]
@OrderStatus - PENDING, PREPARING, READY, SERVED, PAID, CANCELLED
@Bill - orderId, totalAmmount, PaymentStatus
@Reservation - id, customerName, contactNumber, partySize, reservationTime

@I<>Payment - paymentProcessor()
CashPayment 
CreditCardPayment 
UPIPayment 
@PaymentStatus - PENDING, COMPLETED, FAILED

@RestaurantManagementSystem - instance, <>MenuItems <>Ordes, <>Reservations 
,<>Payments, <>Staff, <>Tables
[addMenuItem(), addTable(), reserveTable(), makeReservation(), placeOrder(), getBill(), makePayment()
notifyKitchen(), notifyStaff() ]

======================================================================

22. Design Concert Ticket Booking System

@Concert -  id , artist, venue, dataTime, <>Seats
@Seat - id, seatNumber, SeatType, price [ book(), release() ]
@SeatType - REGULAR, PREMIUM, ECONOMY
@SeatStatus - AVAILABLE, BOOKED, RESERVED
@SeatNotAvailableException 

@User - id, name, email, Bookings

@Booking - id, User, Concert, <>Seats, BookingStatus, totalPrice [calculateTotalPrice(), confirmBooking(), cancelBooking()]
@BookingStatus - PENDING, CONFIRM, CANCELLED 

@CocertBookingSystem - instance, <>Concerts, <>Bookings, lock
 [addConcert(), searchConcert(), bookTickets(), cancelBooking(), processPayment() ]
 
 --- can add ----
 @PaymentProcessor - <------------ Strategy Pattern

======================================================================


23. Design CricInfo 

@Player - id, name, role
@Team - id, name, <>Players
@Match - id, title, venue, startTime, <>Teams, MathcStatus, ScoreCard 
@MatchStatus - SCHEDULED, IN_PROGRESS, COMPLETED, ABANDONED
@MatchService - instance, <>Matches 
[addMath(), updateMatchStatus()]

@Ball - ballNumber, bowler, batsMan, result
@Over - overNumber, <>Balls
@Inning - id, battingTeamId, bowlingTeamId, <>Overs
@ScoreCard - id, Match, <>teamScores, <>Innings
@ScoreCardService - instance, <>ScoreCards, Automic scoreCardIdNumber
[addInning(), updateScore(), createScorecard()]

@CricinfoSystem - MatchService, ScoreCardService
[addMatch(), updateMatchStatus(), createScorecard(), updateScore(), addInning()]

======================================================================

24. Design Splitwise

@User - id, name , email
@Group - groupId, name, <>Users, createdDate

@Expense - expeneId, amount, description, Group, UserpaidBy, <>Splits, createdDate 
@Split - User, ammount

@BalanceSheet -  Map<User, Map<User, Double>> balances; // Map of balances: balances.get(A).get(B) means how much B owes A
[updateBalance(), settleBalance() , printBalanceForUser()]

@SplitStrategy - List<Split> calculateSplits(Map<User, Double> splitData, double totalAmount);
@SplitStrategyFactory - getStrategy(SplitType splitType)
@SplitType - EQUAL, EXACT, PERCENTAGE
@EqualSplitStrategy - splits.add(new Split(user,  totalAmount / numberOfUsers)); 
@ExactSplitStrategy - splits.add(new Split(entry.getKey(), entry.getValue()));
@PercentageSplitStrategy - splits.add(new Split(entry.getKey(), (totalAmount * percentage) / 100.0));

@SplitwiseService - instance, <>Users, <>Groups, <>Expenses, BalanceSheet 
[createUser(), createGroup(), addExpenseUsingStratgy(), settle(), deleteExpense()]

======================================================================

25. Design Chess Game

@Board - <<>>Cells [setupPieces(), movePiece(Move) todos ..isCheckmate(), isSaleMate()]
@Cell - row, col, Piece [ getPiece(), setPiece()] 
@Move - Cellstart Cellend 

@Piece - Color [ canMove() ]
@Color - WHITE, BLACK
@King - (rowDiff <= 1 && colDiff <= 1)
@Queen - (rowDiff == colDiff) || (from.getRow() == to.getRow() || from.getCol() == to.getCol());
@Knight - (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)
@Bishop - (rowDiff == colDiff)
@Rook - (from.getRow() == to.getRow() || from.getCol() == to.getCol())
@Pawn - int rowDiff = to.getRow() - from.getRow(); int colDiff = Math.abs(to.getCol() - from.getCol());  if (color == Color.WHITE) { return (rowDiff == 1 && colDiff == 0) || (from.getRow() == 1 && rowDiff == 2 && colDiff == 0) || (rowDiff == 1 && colDiff == 1 && board.getPiece(to.getRow(), to.getCol()) != null); } else { return (rowDiff == -1 && colDiff == 0) || (from.getRow() == 6 && rowDiff == -2 && colDiff == 0) || (rowDiff == -1 && colDiff == 1 && board.getPiece(to.getRow(), to.getCol()) != null); }

@Payer - name, Color

@ChessGame - board, blackPlayer, whitePlayer, currentPlayer (state) < -------- State management
[start(), getPlayerMove(), switchTurn()]

======================================================================

26. Design Snake & Ladder Game

@Board - size1DArray , <>Snakes , <>Ladders [getNextPosition()]
@Snake - head, tail
@Ladder - start, end
@Dice - minVal ,maxVal [ roll() ]
 
@Player - name, position

@Game - Board, <>Players, Dice [ play(), isGameOver() ]  <----Builder

======================================================================

27. Design Ride Sharing Service - Uber

@Location - lati, longi  [distTo()] //Math.sqrt(dx * dx + dy * dy); // Euclidean for simplicity

@IUser - id, name , contact
@Rider - current Trip
@Driver - license, location, DriverStatus, current Trip, IVehicle
[isAvailable(), assignTrip(), cancelTrip(), completeTrip(), updateLocation()]
@DriverStatus - AVAILABLE, BUSY

@Trip - id, Rider, Driver, source, dest, fair, PaymentStatus, TripStatus
@TripStatus - REQUESTED, ACCEPTED, ONGOING, COMPLETED, CANCELLED

@IVehicle - canSet in Driver

@IPaymentStratgey <--------- Strategy

@RideSharingService - instance, <>Riders, <>Drivers, <>Trips
[registerRider(), registerDriver(), updateDriverLocation(), requestRide(), acceptRide(),
startRide(), cancelRide(), completeRide(), calculateFare(), makePayment(), 
notifyNearbyDrivers(), notifyRider(), notifyDriver() ]

======================================================================

28 Design University Course Registration System 

@Student - id, name, email, <>enrolled Cources

@Course - code,  name , instructor, maxCapacity, <>enrolled Students

@Registeration - id, Student, Course, registrationTime

@CourseRegistrationSystem - <>Students, <>Courses, <>Registerations
[enroll(studId, courId), drop(studId, courId), getAvailableCourses(), searchCourse()]

======================================================================

29. Design Movie Ticket Booking System - BookMyShow

@User - id, name , email, <>TicketBookings

@Movie - id, title, description, duration

@Seat - id, row, col, SeatType, SeatStatus  <-------- Factory Pattern
@SeatType - NORMAL,PREMIUM
@SeatStatus - AVAILABLE, BOOKED

@Show - id, Theator, Movie, startTime, endTime, ShowType, <>Seats
@ShowType - PVR, IMAX, 3D
@Theater - id, name, location, <>Shows

@TicketBookings - id, User, Show, <>Seats, totalPrice, BookingStatus
@BookingStatus - PENDING, CONFIRMED, CANCELLED

@MovieTicketBookingSerivce - instance, <>Shows, <>Users, <>Bookings  < ---- Singleton
[bookTickets(user,show,seats) , areSeatsAvailable(), markSeatsAsBooked(), calculateTotalPrice()
generateBookingId(), pay&ConfirmBooking(), cancelBooking(), markSeatsAsAvailable()]

@PaymentStratgey <--- Strategy
@PricingStrategy <--- Strategy
@AddNotifyForSeatAvaibility <----Observer

======================================================================

30. Design Online Shopping - Amazon

@User - id, name, email, pass, Cart, <>Orders
@IProduct - id, name, desc, category, price, stock

@Cart - id, <>Products

@OrderItem - Product, quantity
@Order - id, User, <>OrderItems, totalPrice, OrderStatus [calcTotal(), cancel()]
@OrderStatus - PENDING, PLACED, SHIPPED, DELIVERED, CANCELLED

--- separate payment service to get payment ----
@PaymentStratgey - processPayment()
@PaymentStatus - FAILED, SUCCESSFUL
@PaymentType - COD, UPI, CREDIT_CARD

@OnlineShoppingApp - instance, <>Users, <>Products, <>Orders
[registerUser(), addProduct(), searchProducts(), addToCart(), 
placeOrder(userId,payment), cancelOrder(orderId)]

======================================================================

31. Design Stock Brokerage - Grow

@User - userId, name, email
@Account - accountId, User, balance, Portfolio
@Portfolio - Account, <> holdings

@Stock - symbol, name, price

@IOrder - orderId, Account, Stock, quantity, price, OrderStatus [execute()]
@BuyOrder - [execute()//account.deposit(totalProceeds)]
@SellOrder - [execute()//account.withdraw(totalCost)]
@OrderStatus - PENDING, EXECUTED, REJECTED

@NotifyOrderStatus -//notify user while buyQueu/sellQueue

@StockBroker - instance, <>Accounts, <>Stocks, <>OrderQueue, AtomicInt accountIdCounter
[createAccount(), placeOrder(), processOrders()//ConcurrentLinkedQueue]

App - 
User, createAccount(user)
Stock, addStock(stock), 
Order, placeOrder(buyOrder1);

======================================================================

32. Design Music Streaming Service - Spotify

@Song - id, name, Artist, Album, Duration
@Artist - id, name, <>Albums
@Album - id, title, Artist, <>Songs

@MusicLibrary - instance, <>Songs, <>Artists, <>Albums
@MusicRecommender - instance, <>userRecommendations  [recommendSongs()]

@User - id, username, pass, <>Playlists, PlayBackSession , songsQueue if neded
[createPlaylist() , pause(), seekTo(), play()]
@PlayList - id, title, User, <>Songs
@PlayBackSession - currentSong, isPlaying, songCurrTime [pause(), seekTo(), play()]

@UserManager - instance, <>Users
[registerUser(), getUserPlaylist()]

@MusicStreamingService - MusicLibrary, MusicRecommender, PlayBackSession
[registerUser(), addNewSong(), addNewAlbum(), addAlbumToArtist(),
playSong(), pauseSong(), createPlaylist(), addSongToPlaylist(), searchSongs()]
TODO - Play PlayList by maintaining Song Queue for User

======================================================================

33. Design Food Delivery Service

@Customer - id, name , email, address, phone, <>Orders
@Restaurant - id, name, location, <>Items, isAvailable

@Item - id, name, price, available
@OrderItem - Item, quantity
@Order - id, Customer, Restaurant, <>OrderItems, OrderStatus, DeliveryAgent
[addItem(), updateStatus(), assignDeliveryAgent()]
@OrderStatus - PENDING, COMFIRMED, PREPARING, OUT_FOR_DELIVERY, DELIVERED, CANCELLED

@DeliveryAgent - id, name, phone, available
[assign(), release()]
@PaymentStratgey - processPayment
@PaymentStatus - PENDING, COMPLETED, CANCELLED
@PaymentType - COD, UPI, CREDIT_CARD

@FoodDeliveryService - instance, <>Restaurants, <>Users, <>Orders, <>DeliveryAgents
[registerCustomer(), registerRestaurant(), registerDeliveryAgent(), getAvailableRestaurants()
addMenuItem(), placeOrder(), updateOrderStatus(), cancelOrder(), assignDeliveryAgent()
notifyCustomer(), notifyRestaurant(), notifyDeliveryAgent() ]

======================================================================

34. Design Parking Lot
35. Design Parking Lot
36. Design Parking Lot
37. Design Parking Lot



