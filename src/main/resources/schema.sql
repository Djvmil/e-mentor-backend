CREATE TABLE User (
    userID INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    -- Additional profile information fields as needed
);

CREATE TABLE Interview (
    interviewID INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    description TEXT,
    requiredSkills VARCHAR(255),
    company VARCHAR(255),
    dateTime DATETIME
    -- Additional fields related to interviews
);

CREATE TABLE Question (
    questionID INT PRIMARY KEY AUTO_INCREMENT,
    questionText TEXT,
    questionType VARCHAR(50)
    -- Additional fields related to questions
);

CREATE TABLE Response (
    responseID INT PRIMARY KEY AUTO_INCREMENT,
    userID INT,
    interviewID INT,
    questionID INT,
    responseText TEXT,
    score DECIMAL(5,2),
    FOREIGN KEY (userID) REFERENCES User(userID),
    FOREIGN KEY (interviewID) REFERENCES Interview(interviewID),
    FOREIGN KEY (questionID) REFERENCES Question(questionID)
    -- Additional fields related to responses
);

CREATE TABLE Community (
    communityID INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description TEXT
    -- Additional fields related to communities
);

CREATE TABLE CommunityMembership (
    userID INT,
    communityID INT,
    PRIMARY KEY (userID, communityID),
    FOREIGN KEY (userID) REFERENCES User(userID),
    FOREIGN KEY (communityID) REFERENCES Community(communityID)
    -- Additional fields related to community memberships
);

CREATE TABLE CommunityQuestion (
    questionID INT PRIMARY KEY AUTO_INCREMENT,
    communityID INT,
    userID INT,
    questionText TEXT,
    dateTime DATETIME,
    FOREIGN KEY (communityID) REFERENCES Community(communityID),
    FOREIGN KEY (userID) REFERENCES User(userID)
    -- Additional fields related to community questions
);

CREATE TABLE CommunityResponse (
    responseID INT PRIMARY KEY AUTO_INCREMENT,
    questionID INT,
    userID INT,
    responseText TEXT,
    dateTime DATETIME,
    FOREIGN KEY (questionID) REFERENCES CommunityQuestion(questionID),
    FOREIGN KEY (userID) REFERENCES User(userID)
    -- Additional fields related to community responses
);

CREATE TABLE Blog (
    blogID INT PRIMARY KEY AUTO_INCREMENT,
    userID INT,
    title VARCHAR(255),
    content TEXT,
    dateTime DATETIME,
    FOREIGN KEY (userID) REFERENCES User(userID)
    -- Additional fields related to blogs
);

CREATE TABLE BlogQuestion (
    questionID INT PRIMARY KEY AUTO_INCREMENT,
    blogID INT,
    userID INT,
    questionText TEXT,
    dateTime DATETIME,
    FOREIGN KEY (blogID) REFERENCES Blog(blogID),
    FOREIGN KEY (userID) REFERENCES User(userID)
    -- Additional fields related to blog questions
);

CREATE TABLE BlogResponse (
    responseID INT PRIMARY KEY AUTO_INCREMENT,
    questionID INT,
    userID INT,
    responseText TEXT,
    dateTime DATETIME,
    FOREIGN KEY (questionID) REFERENCES BlogQuestion(questionID),
    FOREIGN KEY (userID) REFERENCES User(userID)
    -- Additional fields related to blog responses
);

CREATE TABLE Tip (
    tipID INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    description TEXT
    -- Additional fields related to tips
);

CREATE TABLE TipCategory (
    tipID INT,
    category VARCHAR(50),
    PRIMARY KEY (tipID, category),
    FOREIGN KEY (tipID) REFERENCES Tip(tipID)
    -- Additional fields related to tip categories
);
