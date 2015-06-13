
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



