Kabir Uttamsingh
5/5/2017

CSE241

HURTS RENT-A-LEMON README

Welcome to the README.

A few notes about the project.
1. When kku219.jar is run, You must enter an ORACLE ID and PASSWORD to access the database
2. The Program will then ask you if you are a Customer or Employee
	- Note: Once Customer or Employee is selected. In order to run the latter, the program must be restarted
3. CUSTOMER
- Customers have the option to Make a Rental or Exit
- If a Customer want's to update his or her rental or personal information, They must contact an employee
- Once Make a Rental is selected the interface will ask if the customer has registered with Hurts before or not
	- If Yes is selected, Enter a Driver License Number to continue with the rental
		- Some test Driver's License Numbers to use include:
			- 3874143834
			- 1392321975
		        - 3333333333
	 -If No is selected, user will be prompted to enter information to register
- After the Registration status is checked, the rental will begin
- User will be prompted to enter a Pick Up Location, Drop Off Location, Pick Up and Drop Off Dates
	- Once the information above has been selected, the program will display the vehicles available from that pick up location during those dates'
	- A few good Pick Up Locations to test
		- 5024 has no Vehicles in it so user should be reprompted
		- 5000 has 4 vehicles currently at its location
			- 2 of the cars have been reserved in the future
			   - EEE02ZAL5VL3KR6PX is reserved May 7 to May 20
		 	   - HYZ50FSU1SX5AZ0AY is reserved May 25 to May 30
		           - If pick up date and/or drop off entered is in between one of those days that certain car wont show up as available
		- 5002 has 4 vehicles currently at its location
		        - 1 of the cars has been reserved in the future
			   - 1111111111111111 is reserved may 12 to may 20
	        - 5003 has 1 vehicle currently at its location


4. Employee
	- Reservation Manager
		- Make Rental (Same functionality as a customer making a rental)
		- View/Update Customer
			- Add Customer
			- Delete Customer
				- Dl_Numbers to test
					- 7517269861
					- 5003283560
					- 2100246068
			- Update Customer
				- DL_Numbers to test
					- 7517269861
					- 5003283560
					- 2100246068
		- View/Update Rentals
			- Delete Rental
			- Update Rental
				- Can't update past rentals 
					- 70021
					- 70018
				- Can update future rentals
					- 70098
					- 70097
	
		- Process a Return
			- For a rental to be returned, the drop_off date must be the current date
			- I have spread out a few rentals that are elgible to be returned
			- There are no same day make rentals so if you make a rental I suggest making it 2 days long so you can test the return
	- Inventory Manager
		- View Inventory by location
			- Select Location 5000
			- 5 cars
			- View rentals 
				- WBY11NRF3YJ9UL2QM
					- has no rentals associated
				- HYZ50FSU1SX5AZ0AY
					- has 2 rentals associated
		- View Location of Vehicle
			- Choose any Vehicle!
			JRE18PRN5MP4KA9JS
			RHV75BJC1LD9KN8RW
			CTU18KZF3PC5RJ6XX
			BLL30CEY6DA1PW9NX
			FSY33SPG0SL7GN4ZR
			BCA36IKF3EM1VJ9OX
			MDP62UHI8IC1SK6XL
			JUK87OBH6NS5JZ5KY
			QYR87ZTY8KK9MV5QZ
			ZVH91OPK4KD2VG3KK
			QTW58VHO1ML3OI7LT
			OHX12DVQ7DO9DU7ZX
			OPP67TWA5OQ9UN3RD
		- Add a Vehicle
	- Financial Manager
		- View Invoice of a Rental
		- Assumption: It is possible to get invoice of any rental including past present and future
			- The current and future rentals do not include carbon offset and fuel charges
		- 70098 = future rental
		- 70026 = past rental


5. What's in here?
	- kku219 (directory)
		- MainInterface.java
		- Manifest.txt
	- kku219.tar (executable)
	- MainInterface.class
	- ojdbc6.jar
	- README
6. To compile:
	- Move files from kku219(director) to main directory
	- javac MainInterface.java