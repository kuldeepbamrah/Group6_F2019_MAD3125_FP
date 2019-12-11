# Employee Payroll System

Project Designed by : 

Rizul Goyal (C0766598)
Kuldeep Singh (C0757769)


We designed a employee database system which stores different type of employees data and calculate their salary according to the particular fields. It also has a feature to store the information of the vehicles of the employess. One can store multiple vehicles for one employee. The given below features are there in our Project: 

  - Splash Screen 
  - Login Screen with validation
  - Add Employee Fragment with validation
  - View Employee Fragment
  - Detail Employee Activity
  -  Add Vehicle Activity (Context Menu)
  - Help Fragment with alert Dialog
  - Logout for exit


You can do:

  - View Employees (recycler view) 
  - View detail of employee on click at recycler cell
  - Add new Employee with appropiate changing layouts and spinner 
  - Add vehicle with appropiate fields.
  - Delete Vehicle and employee details.
  - 
  
# Highlights of our Project

- We used Room Database to store permanent Data
- Livedata is observing the chnage in Data
- Reading data from JSON by using Json parsing and GSON
- Swipe function to delete the data
- Navigation drawer for menu display.
- Context menu for additional options
- Card view for better design
- Custom dialog for alerts.
- Spinner for selecting fixed values
  

# Screens Details

1. Splash Screen


![Screenshot_1576079977.png](https://www.dropbox.com/s/ifrl8miwc4f5ifa/Screenshot_1576079977.png?dl=0&raw=1)

In This screen, we use Imageviews to design the splash Screen and set it as launcher in manifests. We set sleep for 3000 ns to display on the screen.


2. Login Screen

![Screenshot_1576079845.png](https://www.dropbox.com/s/ceq3750snz0ost0/Screenshot_1576079845.png?dl=0&raw=1)

In Login Screen, we add image as background and edit text to get values. we add validation to check the user details.
By default username is user@employee.com and password is s3cr3t.


3. Main Activity


![Screenshot_1576091762.png](https://www.dropbox.com/s/cs15ktc151eodzn/Screenshot_1576091762.png?dl=0&raw=1)

In This activity, we add a navigation drawer to pop up the menu of the application. In this, we add custom fragments to display the content of our application. we have 5 oprions in the navigation drawer on which functionality of whole application is dependent.

4. Home Fragment


![Screenshot_1576079984.png](https://www.dropbox.com/s/wwhg3mddkbbquk4/Screenshot_1576079984.png?dl=0&raw=1)

In this fragment, we are showing the current date and time by using calendar and simple date format classes. We are also showing the total number of employees by fetching count from database.


5. Add Employee Fragment


![Screenshot_1576079995.png](https://www.dropbox.com/s/3at2k9cykfralm4/Screenshot_1576079995.png?dl=0&raw=1)

In this add employee fragment, we are collecting values from user for  adding new employee in the database system. We use spinner and custom layout to design employee form perfectly. We also use custom dialogues to show alerts while empty fields submission.

6. View employee list Fragment

![Screenshot_1576082737.png](https://www.dropbox.com/s/b22zto0b3he9q4k/Screenshot_1576082737.png?dl=0&raw=1)

In this fragment, we use recycler view to show all the present employees list in which we can further click on employee to see the details of the employee. Also, we can delete the employee by using swipe function.

7. Help Fragment

![Screenshot_1576080001.png](https://www.dropbox.com/s/lqivxdqv277ydlq/Screenshot_1576080001.png?dl=0&raw=1)

In this fragment, we use custom alert dialog to show the contact details through which user can seek help.

8. Logout fragment

In this, we directly redirect the employee to the login page.


9. Employee Detail Activity

![Screenshot_1576094174.png](https://www.dropbox.com/s/ghad62i9ns1hh8p/Screenshot_1576094174.png?dl=0&raw=1)

In this activity we are displaying the detail information of the employee with the recycler view of the vehicles of the employee. we use custom layouts to show different types of employee details.

10. Add Vehicle Activity

![Screenshot_1576081525.png](https://www.dropbox.com/s/unj4nu3rxqx58u8/Screenshot_1576081525.png?dl=0&raw=1)

In this activity, we use different edittext fields and switch to take data from user for adding vehicle. we are also using the custom dialogues to show alert on empty fields submission. 

References :

https://app.slack.com/client/T48D9NT7A/GMCP5QEJF

https://github.com/kuldeepbamrah/Group6_F2019_MAD3125_FP

https://stackoverflow.com
















