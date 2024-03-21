

CREATE TABLE IF NOT EXISTS Users (
    userID SERIAL PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(255),
    genre VARCHAR(255),
    country VARCHAR(255),
    phoneNumber VARCHAR(255),
    birthDate VARCHAR(255),
    isEmailVerified BOOLEAN DEFAULT FALSE,
    isPhoneNumberVerified BOOLEAN DEFAULT FALSE
    -- Additional profile information fields as needed
);

CREATE TABLE IF NOT EXISTS Interviews (
    interviewID SERIAL PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    requiredSkills VARCHAR(255),
    company VARCHAR(255),
    dateTime TIMESTAMP
    -- Additional fields related to interviews
);

CREATE TABLE IF NOT EXISTS Questions (
    questionID SERIAL PRIMARY KEY,
    questionText TEXT,
    questionType VARCHAR(50)
    -- Additional fields related to questions
);

CREATE TABLE IF NOT EXISTS Responses (
    responseID SERIAL PRIMARY KEY,
    userID INT,
    interviewID INT,
    questionID INT,
    responseText TEXT,
    score DECIMAL(5,2),
    FOREIGN KEY (userID) REFERENCES Users(userID),
    FOREIGN KEY (interviewID) REFERENCES Interviews(interviewID),
    FOREIGN KEY (questionID) REFERENCES Questions(questionID)
    -- Additional fields related to responses
);

CREATE TABLE IF NOT EXISTS Communities (
    communityID SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description TEXT
    -- Additional fields related to communities
);

CREATE TABLE IF NOT EXISTS CommunityMemberships (
    userID INT,
    communityID INT,
    PRIMARY KEY (userID, communityID),
    FOREIGN KEY (userID) REFERENCES Users(userID),
    FOREIGN KEY (communityID) REFERENCES Communities(communityID)
    -- Additional fields related to community memberships
);

CREATE TABLE IF NOT EXISTS CommunityQuestions (
    questionID SERIAL PRIMARY KEY,
    communityID INT,
    userID INT,
    questionText TEXT,
    dateTime TIMESTAMP,
    FOREIGN KEY (communityID) REFERENCES Communities(communityID),
    FOREIGN KEY (userID) REFERENCES Users(userID)
    -- Additional fields related to community questions
);

CREATE TABLE IF NOT EXISTS CommunityResponses (
    responseID SERIAL PRIMARY KEY,
    questionID INT,
    userID INT,
    responseText TEXT,
    dateTime TIMESTAMP,
    FOREIGN KEY (questionID) REFERENCES CommunityQuestions(questionID),
    FOREIGN KEY (userID) REFERENCES Users(userID)
    -- Additional fields related to community responses
);

CREATE TABLE IF NOT EXISTS Blogs (
    blogID SERIAL PRIMARY KEY,
    userID INT,
    title VARCHAR(255),
    content TEXT,
    dateTime TIMESTAMP,
    FOREIGN KEY (userID) REFERENCES Users(userID)
    -- Additional fields related to blogs
);

CREATE TABLE IF NOT EXISTS BlogQuestions (
    questionID SERIAL PRIMARY KEY,
    blogID INT,
    userID INT,
    questionText TEXT,
    dateTime TIMESTAMP,
    FOREIGN KEY (blogID) REFERENCES Blogs(blogID),
    FOREIGN KEY (userID) REFERENCES Users(userID)
    -- Additional fields related to blog questions
);

CREATE TABLE IF NOT EXISTS BlogResponses (
    responseID SERIAL PRIMARY KEY,
    questionID INT,
    userID INT,
    responseText TEXT,
    dateTime TIMESTAMP,
    FOREIGN KEY (questionID) REFERENCES BlogQuestions(questionID),
    FOREIGN KEY (userID) REFERENCES Users(userID)
    -- Additional fields related to blog responses
);

CREATE TABLE IF NOT EXISTS Tips (
    tipID SERIAL PRIMARY KEY,
    title VARCHAR(255),
    description TEXT
    -- Additional fields related to tips
);

CREATE TABLE IF NOT EXISTS TipCategories (
    tipID INT,
    category VARCHAR(50),
    PRIMARY KEY (tipID, category),
    FOREIGN KEY (tipID) REFERENCES Tips(tipID)
    -- Additional fields related to tip categories
);
