DROP DATABASE MyJoinsDB;
CREATE DATABASE MyJoinsDB;
USE MyJoinsDB;

# В 1-й таблице содержатся имена и номера телефонов сотрудников компании
CREATE TABLE Employees (
  EmployeeID INT PRIMARY KEY AUTO_INCREMENT,
  FirstName VARCHAR(50),
  LastName VARCHAR(50),
  PhoneNumber VARCHAR(20)
);
# Во 2-й таблице содержатся ведомости о зарплате и должностях сотрудников: главный директор, менеджер, рабочий.
CREATE TABLE Salaries (
  EmployeeID INT ,
  Position VARCHAR(50),
  Salary DECIMAL(10,2),
  PRIMARY KEY (EmployeeID),
  FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID)
);

CREATE TABLE PersonalInfo (
  EmployeeID INT ,
  BirthDate DATE,
  MaritalStatus VARCHAR(10),
  Address VARCHAR(100),
  PRIMARY KEY (EmployeeID),
  FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID)
);

-- Получите информацию обо всех менеджерах компании: дату рождения и номер телефона. 

INSERT INTO Employees (EmployeeID, FirstName, LastName, PhoneNumber)
VALUES (1, 'Іван', 'Сірко', '+380-97-123-45-67'),
       (2, 'Петро', 'Сагайдачний', '+380-66-789-12-34'),
       (3, 'Сергій', 'Богдан', '+380-50-901-23-45'),
       (4, 'Ольга', 'Тригуб', '+380-63-456-78-90'),
       (5, 'Наталія', 'Мосійчук', '+380-97-555-55-55');

INSERT INTO Salaries (EmployeeID, Position, Salary)
VALUES (1, 'головний директор', 100000),
       (2, 'менеджер', 50000),
       (3, 'робітник', 25000),
       (4, 'робітник', 25000),
       (5, 'робітник', 25000);
       
INSERT INTO PersonalInfo (EmployeeID, BirthDate, MaritalStatus, Address)
VALUES (1, '1980-01-01', 'одружений', 'м. Київ, вул. Леніна, 1'),
       (2, '1985-03-15', 'холостий', 'м. Львів, вул. Галицька, 20'),
       (3, '1990-05-20', 'холостий', 'м. Харків, вул. Гагаріна, 5'),
       (4, '1995-07-25', 'заміжня', 'м. Одеса, вул. Дерибасівська, 10'),
       (5, '2000-09-30', 'холостий', 'м. Дніпро, просп. Гагаріна, 15');
   
   


