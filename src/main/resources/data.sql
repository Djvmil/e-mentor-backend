-- Utilisateurs
INSERT INTO User (firstName, lastName, email, password) VALUES
('John', 'Doe', 'john.doe@example.com', 'hashedpassword123'),
('Jane', 'Smith', 'jane.smith@example.com', 'hashedpassword456'),
('Alice', 'Johnson', 'alice.johnson@example.com', 'hashedpassword789');

-- Entretiens
INSERT INTO Interview (title, description, requiredSkills, company, dateTime) VALUES
('Entretien pour développeur web', 'Entretien pour un poste de développeur web junior.', 'HTML, CSS, JavaScript', 'TechCorp', '2024-01-15 10:00:00'),
('Entretien pour gestionnaire de projet', 'Entretien pour un poste de gestionnaire de projet expérimenté.', 'Gestion de projet, Communication, Leadership', 'Consulting Inc.', '2024-01-20 14:00:00');

-- Questions
INSERT INTO Question (questionText, questionType) VALUES
('Parlez-moi de vous.', 'Behavioral'),
('Quelles sont vos compétences techniques ?', 'Technical');

-- Réponses
INSERT INTO Response (userID, interviewID, questionID, responseText, score) VALUES
(1, 1, 1, 'Je suis un développeur web passionné avec 2 ans d''expérience dans le développement de sites web responsives.', NULL),
(1, 1, 2, 'Mes compétences techniques incluent HTML, CSS, JavaScript et React.', NULL),
(2, 2, 1, 'Je suis un gestionnaire de projet avec 5 ans d''expérience dans le secteur de la consultation.', NULL),
(2, 2, 2, 'Mes compétences techniques incluent la maîtrise de Microsoft Project et la gestion agile.', NULL);

-- Communautés
INSERT INTO Community (name, description) VALUES
('Développeurs en herbe', 'Une communauté pour les développeurs débutants.'),
('Professionnels en gestion de projet', 'Une communauté pour les professionnels expérimentés en gestion de projet.');

-- Adhésions à la communauté
INSERT INTO CommunityMembership (userID, communityID) VALUES
(1, 1),
(2, 2);

-- Questions de la communauté
INSERT INTO CommunityQuestion (communityID, userID, questionText, dateTime) VALUES
(1, 1, 'Quelles sont les meilleures ressources pour apprendre le développement web ?', '2024-01-10 12:00:00'),
(2, 2, 'Comment gérez-vous les conflits d''équipe dans un projet ?', '2024-01-11 15:00:00');

-- Réponses de la communauté
INSERT INTO CommunityResponse (questionID, userID, responseText, dateTime) VALUES
(1, 2, 'Je recommande les tutoriels en ligne sur FreeCodeCamp et Codecademy.', '2024-01-10 14:00:00'),
(2, 1, 'La communication ouverte et la résolution de problèmes collaborative sont essentielles.', '2024-01-11 16:00:00');

-- Blogs
INSERT INTO Blog (userID, title, content, dateTime) VALUES
(1, 'Introduction au développement web', 'Dans cet article, nous allons discuter des bases du développement web.', '2024-01-05 09:00:00'),
(2, 'Conseils pour une gestion de projet efficace', 'Découvrez quelques conseils pratiques pour améliorer la gestion de vos projets.', '2024-01-08 11:00:00');

-- Questions des blogs
INSERT INTO BlogQuestion (blogID, userID, questionText, dateTime) VALUES
(1, 3, 'Quels langages de programmation devrais-je apprendre en premier pour devenir un développeur web ?', '2024-01-06 10:00:00'),
(2, 1, 'Comment puis-je motiver mon équipe lorsqu''elle est confrontée à des défis ?', '2024-01-09 12:00:00');

-- Réponses des blogs
INSERT INTO BlogResponse (questionID, userID, responseText, dateTime) VALUES
(1, 2, 'Je recommande de commencer par HTML, CSS et JavaScript.', '2024-01-06 12:00:00'),
(2, 2, 'La motivation peut être encouragée en célébrant les petites victoires et en fournissant un soutien continu.', '2024-01-09 14:00:00');

-- Conseils
INSERT INTO Tip (title, description) VALUES
('Préparation à l''entretien', 'Pratiquez vos réponses aux questions courantes et faites des recherches sur l''entreprise avant l''entretien.'),
('Gestion du temps', 'Établissez des priorités et utilisez des outils de gestion du temps pour rester organisé.');

-- Catégories de conseils
INSERT INTO TipCategory (tipID, category) VALUES
(1, 'Entretien d''embauche'),
(2, 'Développement personnel');
