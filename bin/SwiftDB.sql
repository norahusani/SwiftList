
CREATE TABLE Songs (
	Title VARCHAR(100) NOT NULL,
	Album VARCHAR(50) NOT NULL,
	Id INT NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (Id) REFERENCES Moods (SId)
);

CREATE TABLE Moods (
	SId INT NOT NULL,
	Happy BOOLEAN NOT NULL,
	Sad BOOLEAN NOT NULL,
	Mad BOOLEAN NOT NULL,
	Free BOOLEAN NOT NULL,
	Confused BOOLEAN NOT NULL,
	Frustrated BOOLEAN NOT NULL,
	Regretful BOOLEAN NOT NULL,
	Nostalgic BOOLEAN NOT NULL,
	Betrayed BOOLEAN NOT NULL,
	Lonely BOOLEAN NOT NULL,
	Empowered BOOLEAN NOT NULL,
	Afraid BOOLEAN NOT NULL,
	Vengeful BOOLEAN NOT NULL,
	Sarcastic BOOLEAN NOT NULL,
	Social BOOLEAN NOT NULL,
	Hopeful BOOLEAN NOT NULL,
	Desperate BOOLEAN NOT NULL,
	Foolish BOOLEAN NOT NULL,
	Amazed BOOLEAN NOT NULL,
	Brave BOOLEAN NOT NULL,
	PRIMARY KEY (SId)
);

INSERT INTO Songs VALUES("Tim McGraw", "Taylor Swift", 1);
INSERT INTO Songs VALUES("Picture To Burn", "Taylor Swift", 2);
INSERT INTO Songs VALUES("Teardrops On My Guitar", "Taylor Swift", 3);
INSERT INTO Songs VALUES("A Place In This World", "Taylor Swift", 4);
INSERT INTO Songs VALUES("Cold As You", "Taylor Swift", 5);
INSERT INTO Songs VALUES("The Outside", "Taylor Swift", 6);
INSERT INTO Songs VALUES("Tied Together With A Smile", "Taylor Swift", 7);
INSERT INTO Songs VALUES("Stay Beautiful", "Taylor Swift", 8);
INSERT INTO Songs VALUES("Should've Said No", "Taylor Swift", 9);
INSERT INTO Songs VALUES("Mary's Song (Oh My My My)", "Taylor Swift", 10);
INSERT INTO Songs VALUES("Our Song", "Taylor Swift", 11);
INSERT INTO Songs VALUES("I'm Only Me When I'm With You", "Taylor Swift", 12);
INSERT INTO Songs VALUES("Invisible", "Taylor Swift", 13);
INSERT INTO Songs VALUES("Perfectly Good Heart", "Taylor Swift", 14);


INSERT INTO Moods VALUES(1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0);
INSERT INTO Moods VALUES(2, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1);
INSERT INTO Moods VALUES(3, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0);
INSERT INTO Moods VALUES(4, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1);
INSERT INTO Moods VALUES(5, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0);
INSERT INTO Moods VALUES(6, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO Moods VALUES(7, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0 ,1);
INSERT INTO Moods VALUES(8, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1);
INSERT INTO Moods VALUES(9, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1);
INSERT INTO Moods VALUES(10, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1);
INSERT INTO Moods VALUES(11, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1);
INSERT INTO Moods VALUES(12, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0);
INSERT INTO Moods VALUES(13, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0);
INSERT INTO Moods VALUES(14, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);


INSERT INTO Songs VALUES("Jump Then Fall", "Fearless Platinum Edition", 15);
INSERT INTO Songs VALUES("Untouchable", "Fearless Platinum Edition", 16);
INSERT INTO Songs VALUES("Forever & Always (Piano Version)", "Fearless Platinum Edition", 17);
INSERT INTO Songs VALUES("Come In With The Rain", "Fearless Platinum Edition", 18);
INSERT INTO Songs VALUES("Superstar", "Fearless Platinum Edition", 19);
INSERT INTO Songs VALUES("The Other Side Of The Door", "Fearless Platinum Edition", 20);
INSERT INTO Songs VALUES("Fearless", "Fearless", 21);
INSERT INTO Songs VALUES("Fifteen", "Fearless", 22);
INSERT INTO Songs VALUES("Love Story", "Fearless", 23);
INSERT INTO Songs VALUES("Hey Stephen", "Fearless", 24);
INSERT INTO Songs VALUES("White Horse", "Fearless", 25);
INSERT INTO Songs VALUES("You Belong With Me", "Fearless", 26);
INSERT INTO Songs VALUES("Breathe", "Fearless", 27);
INSERT INTO Songs VALUES("Tell Me Why", "Fearless", 28);
INSERT INTO Songs VALUES("You're Not Sorry", "Fearless", 29);
INSERT INTO Songs VALUES("The Way I Loved You", "Fearless", 30);
INSERT INTO Songs VALUES("Forever & Always", "Fearless", 31);
INSERT INTO Songs VALUES("The Best Day", "Fearless", 32);
INSERT INTO Songs VALUES("Change", "Fearless", 33);



