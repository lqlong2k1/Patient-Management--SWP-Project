USE [PatientManagement]
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_ID_BILL]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_ID_BILL]()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID VARCHAR(7)
	IF (SELECT COUNT(ID_BILL) FROM BILL) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(ID_BILL, 5)) FROM BILL
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'BI0000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 and @ID < 99 THEN 'BI000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 99 AND @ID <999 THEN 'BI00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END

GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_ID_DISEASE]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_ID_DISEASE]()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID VARCHAR(7)
	IF (SELECT COUNT(ID_DISEASE) FROM DISEASE) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(ID_DISEASE, 5)) FROM DISEASE
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'DI0000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 and @ID < 99 THEN 'DI000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 99 AND @ID <999 THEN 'DI00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END

GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_ID_MEDICAL]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_ID_MEDICAL]()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID VARCHAR(7)
	IF (SELECT COUNT(ID_MEDICAL) FROM MEDICAL) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(ID_MEDICAL, 5)) FROM MEDICAL
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'ME0000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 and @ID < 99 THEN 'ME000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 99 AND @ID <999 THEN 'ME00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END

GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_ID_SERVICE]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_ID_SERVICE]()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID VARCHAR(7)
	IF (SELECT COUNT(ID_SERVICE) FROM SERVICE_DATA) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(ID_SERVICE, 5)) FROM SERVICE_DATA
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'BI0000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 and @ID < 99 THEN 'BI000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 99 AND @ID <999 THEN 'BI00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END

GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IDPRE]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_IDPRE]()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID VARCHAR(7)
	IF (SELECT COUNT(IDPRE) FROM prescription) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(IDPRE, 5)) FRom prescription
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'PR0000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 and @ID < 99 THEN 'PR000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 99 and @ID < 999 THEN 'PR00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 999 and @ID < 9999 THEN 'PR0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IDUSER]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_IDUSER]()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID VARCHAR(7)
	IF (SELECT COUNT(ID_USER) FROM USER_DATA) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(ID_USER, 5)) FROM USER_DATA
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'US0000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 and @ID < 99 THEN 'US000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 99 AND @ID <999 THEN 'US00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END

GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_MR]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_MR]()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID VARCHAR(7)
	IF (SELECT COUNT(ID_MR) FROM MEDICAL_RECORD) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(ID_MR, 5)) FROM MEDICAL_RECORD
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'MR0000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 and @ID < 99 THEN 'MR000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 99 AND @ID <999 THEN 'MR00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END

GO



SELECT USER_NAME FROM Patient where ID_user like 'US00001'




/****** Object:  Table [dbo].[USER_DATA]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USER_DATA](
	[ID_USER] [varchar](7) NOT NULL,
	[IDF] [varchar](7) NULL,
	[Phone] [varchar](30) NULL,
	[AddressUSER] [varchar](30) NULL,
	[GENDER] [bit] NULL,
	[CCCD] [varchar](30) NULL,
	[EMAIL] [varchar](30) NULL,
	[CODEBHYT] [varchar](30) NULL,
	[USER_NAME] [nvarchar](35) NULL,
	[USER_AGE] [int] NULL,
	[DOB] [datetime] NULL,
	[PATIENT_CAREER] [varchar](35) NULL,
	[USER_ROLE] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_USER] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[Patient]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[Patient] as
 select ID_user,Phone,AddressUser,Gender,cccd,email,codebhyt,user_name,user_age,DOB,PAtient_Career,user_ROLE from USER_DATA
 where user_role='Patient'
GO
/****** Object:  View [dbo].[Doctor]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[Doctor] as
 select ID_user,IDF,Phone,AddressUser,Gender,cccd,email,user_name,user_age,DOB,user_ROLE from USER_DATA
 where user_role='Doctor'
GO
/****** Object:  View [dbo].[Staff]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[Staff] as
 select ID_user,IDF,Phone,AddressUser,Gender,cccd,email,user_name,user_age,DOB,user_ROLE from USER_DATA
 where user_role='Staff'
GO

/****** Object:  Table [dbo].[ACCOUNT]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ACCOUNT](
	[ID_ACCOUNT] [int] IDENTITY(1,1) NOT NULL,
	[USER_PASSWORD] [varchar](15) NULL,
	[ID_USER] [varchar](7) NULL,
	[STATE] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_ACCOUNT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ACCOUNT_LOG]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ACCOUNT_LOG](
	[ID_lOG] [int] IDENTITY(1,1) NOT NULL,
	[NOTE_LOG] [varchar](50) NULL,
	[ID_ACCOUNT] [int] NULL,
	[Date_Log] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_lOG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BILL]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BILL](
	[ID_BILL] [varchar](7) NOT NULL,
	[PATIENT] [varchar](7) NULL,
	[TOTAL] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_BILL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BILL_DETAIL]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BILL_DETAIL](
	[ID_BD] [int] IDENTITY(1,1) NOT NULL,
	[ID_BILL] [varchar](7) NULL,
	[ID_SERVICE] [varchar](35) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_BD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DISEASE]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DISEASE](
	[ID_DISEASE] [varchar](7) NOT NULL,
	[DIS_NAME] [varchar](50) NULL,
	[DIS_DESCRIPTION] [varchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_DISEASE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FACULTY]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FACULTY](
	[IDF] [varchar](7) NOT NULL,
	[FALCULTY_NAME] [varchar](50) NULL,
	[TOTAL_STAFF] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IDF] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MEDICAL]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MEDICAL](
	[ID_MEDICAL] [varchar](7) NOT NULL,
	[MED_NAME] [varchar](50) NULL,
	[MED_DESCRIPTION] [varchar](1000) NULL,
	[Price] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_MEDICAL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MEDICAL_RECORD]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MEDICAL_RECORD](
	[ID_MR] [varchar](7) NOT NULL,
	[DATE_CREATED] [datetime] NULL,
	[SYMPTOM] [varchar](1000) NULL,
	[DOCTOR] [varchar](7) NULL,
	[PATIENT] [varchar](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_MR] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MR_DISEASE]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MR_DISEASE](
	[ID_MRD] [int] IDENTITY(1,1) NOT NULL,
	[ID_MR] [varchar](7) NULL,
	[ID_DISEASE] [varchar](7) NULL,
	[DATE_DIAGNOSE] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_MRD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[prescription]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[prescription](
	[IDPRE] [varchar](7) NOT NULL,
	[IDMR] [varchar](7) NULL,
	[date_created] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[IDPRE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[prescription_detail]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[prescription_detail](
	[IDPRE] [varchar](7) NULL,
	[ID_MEDICAL] [varchar](7) NULL,
	[Quantity] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SCHEDULE]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SCHEDULE](
	[ID_SCHEDULE] [int] IDENTITY(1,1) NOT NULL,
	[ID_SERVICE] [varchar](7) NULL,
	[STAFF] [varchar](7) NULL,
	[Patient] [varchar](7) NULL,
	[date_apm] [date] NULL,
	[START_TIME] [time](7) NULL,
	[END_TIME] [time](7) NULL,
	[CONFIRM] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_SCHEDULE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SERVICE_DATA]    Script Date: 3/25/2022 10:25:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SERVICE_DATA](
	[ID_SERVICE] [varchar](7) NOT NULL,
	[NAME_SERVICE] [varchar](35) NULL,
	[PRICE] [float] NULL,
	[Description] [nchar](1000) NULL,
	[IDF] [varchar](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_SERVICE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ACCOUNT] ON 

INSERT [dbo].[ACCOUNT] ([ID_ACCOUNT], [USER_PASSWORD], [ID_USER], [STATE]) VALUES (1, N'123', N'US00001', 0)
INSERT [dbo].[ACCOUNT] ([ID_ACCOUNT], [USER_PASSWORD], [ID_USER], [STATE]) VALUES (2, N'111', N'US00006', 1)
INSERT [dbo].[ACCOUNT] ([ID_ACCOUNT], [USER_PASSWORD], [ID_USER], [STATE]) VALUES (3, N'12345', N'admin', NULL)
INSERT [dbo].[ACCOUNT] ([ID_ACCOUNT], [USER_PASSWORD], [ID_USER], [STATE]) VALUES (1003, N'1', N'US00003', 0)
SET IDENTITY_INSERT [dbo].[ACCOUNT] OFF
GO
SET IDENTITY_INSERT [dbo].[ACCOUNT_LOG] ON 

INSERT [dbo].[ACCOUNT_LOG] ([ID_lOG], [NOTE_LOG], [ID_ACCOUNT], [Date_Log]) VALUES (1, N'cc', 1, CAST(N'2001-10-23T00:00:00.000' AS DateTime))
INSERT [dbo].[ACCOUNT_LOG] ([ID_lOG], [NOTE_LOG], [ID_ACCOUNT], [Date_Log]) VALUES (2, N'Login', 1, CAST(N'2022-03-03T00:00:00.000' AS DateTime))
INSERT [dbo].[ACCOUNT_LOG] ([ID_lOG], [NOTE_LOG], [ID_ACCOUNT], [Date_Log]) VALUES (3, N'Update Password Account', 1, CAST(N'2022-03-10T11:05:25.400' AS DateTime))
SET IDENTITY_INSERT [dbo].[ACCOUNT_LOG] OFF
GO
INSERT [dbo].[BILL] ([ID_BILL], [PATIENT], [TOTAL]) VALUES (N'BI00001', N'US00002', 2)
GO
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00001', N'Cancer', N'Cancer is a disease that occurs when abnormal cells appear, grow out of control and form a tumor. Gradually, cancer cells will invade and destroy normal body tissues, starting from the primary organ to the whole body.')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00002', N'COVID-19', N'COVID-19 (coronavirus disease 2019) is an illness caused by a virus called SARS-CoV-2. COVID-19 usually causes respiratory symptoms, which can feel like a cold, flu, or pneumonia. COVID-19 can attack more than just the lungs and respiratory system of an infected person. Other parts of the patient''s body can also be affected by the disease.')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00003', N'High blood pressure', N'High blood pressure (or hypertension) is a chronic disease where the pressure of the blood against the walls of the arteries is too high. High blood pressure puts a lot of pressure on the heart (increases the burden on the heart) and is the cause of many serious cardiovascular complications such as: cerebrovascular accident, heart failure, coronary heart disease, myocardial infarction ,...')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00004', N'Diabetes', N'Diabetes, medically known as diabetes mellitus, is a very common chronic metabolic disorder. With diabetes, your body loses its ability to use or produce the hormone insulin properly. Having diabetes means you have very high blood sugar for many reasons. This condition can cause serious problems for the body, including the eyes, kidneys, nerves, and heart.')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00005', N'Chicken pox', N'Chickenpox is a contagious skin disease caused by the Varicella Zoster virus (VZV). The initial manifestations of chickenpox are blisters on the skin and mucous membranes, high fever, weakness, and fatigue.')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00006', N'Pneumonia', N'
Pneumonia is an infection of the lung tissue, or inflammation of the alveolar ducts, alveolar sacs, respiratory bronchioles and interstitial tissues. When you have pneumonia, the air sacs in the lungs will contain a lot of mucus, reducing the amount of oxygen supplied to the machine, making it difficult for the patient to breathe. ')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00007', N'Myocardial infarction', N'Myocardial infarction is a sudden complete blockage of one or more branches of the coronary arteries - the arteries that supply blood to the heart, causing the death of heart muscle cells. This is a dangerous condition, directly threatening the life of the patient if not detected and treated promptly.')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00008', N'Gout', N'Gout is a form of arthritis that causes joint pain and swelling, the swelling usually lasts for a week or two and then goes away. Gout swelling usually begins in the big toe or lower extremities. Gout occurs when serum urate salts accumulate in the body.')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00009', N'Malaria ', N'Malaria is one of the most common infectious diseases and a very serious public health problem. The disease is caused by the Plasmodium parasite, which is passed from person to person when they are bitten by a mosquito.')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00010', N'Asthma', N'Asthma (bronchial asthma) is a chronic disease of the respiratory system. During an asthma attack, the lining of the bronchial tubes becomes swollen, inflamed, and easily irritated.')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00011', N'Tubeculosis', N'Tuberculosis is an infectious disease caused by the bacterium Mycobacterium tuberculosis. The disease is spread by TB bacteria that are spread out when a person with pulmonary TB coughs, speaks, sneezes, or spits, which accidentally by close contacts can be inhaled and cause disease in the lungs.')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00012', N'Viral fever', N'Viral fever is a general term for diseases caused by viruses with the main symptom being a fever. Unlike infections with bacterial pathogens, where antibiotics are the mainstay of treatment, antibiotics are ineffective against viral infections such as viral fever.')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00013', N'Low blood pressure', N'Low blood pressure is a condition when blood pressure suddenly drops below 90/60 mmHg. Low blood pressure causes blood volume to decrease because of vasoconstriction.')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00014', N'Ebola', N'Ebola, also known as Ebola hemorrhagic fever, is a deadly disease caused by a virus. There are five strains of the Ebola virus, of which four can cause disease in humans. When the Ebola virus enters the body, it can damage the immune system and other organs. The blood clotting factors will decrease, as a result, the body will experience severe and uncontrolled bleeding.')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00015', N'Diphtheria', N'Diphtheria is a dangerous infection caused by the bacterium Corynebacterium diphtheriae, which is highly contagious and rapidly causes epidemics. This is an acute bacterial infection with pseudomembranous glands in the amygdala, pharynx, larynx, and nose. The disease can appear on the skin, other mucous membranes such as the conjunctiva of the eyes or the genitals.')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00016', N'Cirrhosis', N'Cirrhosis is a chronic liver disease characterized by replacement of liver tissue by fibrous tissue, scarring and the formation of neoplastic nodules leading to loss of liver function.')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00017', N'Influenza', N'Influenza is a respiratory infection caused by influenza viruses. The illness begins suddenly and usually lasts 7 to 10 days.')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00018', N'Rabies', N'Rabies is a disease caused by the rabies virus. This is an acute viral infection of the central nervous system, transmitted by secretions, usually by the bite or lick of a rabid animal. The saliva of a rabid animal can also transmit rabies to humans if it comes into contact with the eyes, mouth, or nose.')
INSERT [dbo].[DISEASE] ([ID_DISEASE], [DIS_NAME], [DIS_DESCRIPTION]) VALUES (N'DI00019', N'Tonsillitis', N'Tonsillitis is a condition in which your tonsils are damaged by acute or chronic inflammation, caused by bacteria or viruses. The massive and excessive attack of bacteria into the nasopharynx will cause the tonsils to work too hard, leading to swollen and red tonsils.')
GO
INSERT [dbo].[FACULTY] ([IDF], [FALCULTY_NAME], [TOTAL_STAFF]) VALUES (N'CXK', N'Co xuong kh?p', 10)
INSERT [dbo].[FACULTY] ([IDF], [FALCULTY_NAME], [TOTAL_STAFF]) VALUES (N'HSTC', N'H?i s?c tích c?c', 10)
INSERT [dbo].[FACULTY] ([IDF], [FALCULTY_NAME], [TOTAL_STAFF]) VALUES (N'N', N'Nhi', 10)
INSERT [dbo].[FACULTY] ([IDF], [FALCULTY_NAME], [TOTAL_STAFF]) VALUES (N'SKTQ', N'S?c kh?e t?ng quát', 10)
INSERT [dbo].[FACULTY] ([IDF], [FALCULTY_NAME], [TOTAL_STAFF]) VALUES (N'SPKHTSS', N'S?n ph? khoa - h? tr? sinh s?n', 10)
INSERT [dbo].[FACULTY] ([IDF], [FALCULTY_NAME], [TOTAL_STAFF]) VALUES (N'TBGCNG', N'T? bào g?c và công ngh? gen', 10)
INSERT [dbo].[FACULTY] ([IDF], [FALCULTY_NAME], [TOTAL_STAFF]) VALUES (N'THGM', N'Tiêu hóa gan m?t', 10)
INSERT [dbo].[FACULTY] ([IDF], [FALCULTY_NAME], [TOTAL_STAFF]) VALUES (N'TM', N'Tim m?ch', 10)
INSERT [dbo].[FACULTY] ([IDF], [FALCULTY_NAME], [TOTAL_STAFF]) VALUES (N'UBXT', N'Ung bu?u - X? tr?', 10)
INSERT [dbo].[FACULTY] ([IDF], [FALCULTY_NAME], [TOTAL_STAFF]) VALUES (N'YHCT', N'Y h?c c? truy?n', 10)
GO
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00001', N'Rocket 1h', N'Sexual enhancement', 300000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00002', N'Molnupiravir 400mg', N'Antiviral drug with a high rate of viral negative, treating patients with mild to moderate SARS-CoV-2.', 260000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00003', N'Paracetamol 1000mg/100ml', N'Relieve headache, reduce fever', 45000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00004', N'Sangobion', N'Supplement vitamin C, B12, iron gluconate, copper sulfate...', 70000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00005', N'Salbutamol 2mg', N'Treatment of Asthma, relieves narrowing of the airways, Chronic bronchitis, Emphysema.', 120000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00006', N'Aspirin', N'Aspirin is effective in reducing fever and relieving pain ranging from mild to moderate pain such as muscle aches, toothaches, the common cold, and headaches. Medicines can also be used to reduce pain and swelling caused by arthritis. Aspirin is a salicylate and a non-steroidal anti-inflammatory drug (NSAID).', 150000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00007', N'Terpincodein-F', N'Relieve cough, expectorant in cases of wind cough, dry cough, cough due to bronchitis, acute or chronic bronchitis', 66000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00008', N'Cefuroxim 500mg', N'Treatment of diseases of the respiratory tract', 40000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00009', N'Montelukast 10Mg', N'Treatment of asthma', 30000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00010', N'Ambroxol Cough Syrup 15Mg/5ml', N'Treatment of disorders of secretion in bronchi, mainly in acute bronchial diseases: Acute bronchitis, acute stage of chronic bronchopulmonary diseases.', 30000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00011', N'Acyclovir STADA', N'Treatment and prevention of recurrence of:
Skin ulcers caused by herpes simplex virus infection
Chicken pox
Genital Herpex Infection
Shingles', 50000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00012', N'Allopurinol', N'Reduce uric acid levels', 120000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00013', N'Diamicron MR 60', N'Treatment of diabetes', 300000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00014', N'Natri Clorid 0.9%', N'Clean the wound, remove dirt', 5000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00015', N'Dabigatran 110mg', N'Prevention of stroke and systemic embolism in patients with nonvalvular atrial fibrillation', 40000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00016', N'Apixaban 2.5mg', N'To reduce the risk of stroke and embolism in people with non-fibrillation atrial fibrillation.', 55000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00017', N'Methylprenisolone', N'Suppressing the body''s immune system in response to various diseases, thereby helping to relieve unpleasant symptoms such as swelling, pain and allergies', 65000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00018', N'Rivaroxaban 10mg', N'Prevent the formation of blood clots. Rivaroxaban is commonly used to: Prevent and treat blood clots and reduce the risk of stroke', 45500)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00019', N'Dexamethasone', N'Treatment of diseases such as rheumatism, blood or hormone dysfunction, immune system, allergies, ...', 31500)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00020', N'Nimotop 30mg', N'Prevention & treatment of ischemia causing neurological insufficiency due to cerebral vasospasm after subarachnoid hemorrhage', 540000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00021', N'Berberin', N'Treatment of intestinal diseases such as bacillus dysentery, dysentery syndrome, enteritis, diarrhea, bile duct inflammation.', 4000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00022', N'Fucidin', N'Kill bacteria that cause skin infections, improve swelling, inflammation, redness, itchy skin...', 55000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00023', N'Primolut N', N'Medicines to treat amenorrhea, premenstrual syndrome, mammary gland disease, menstrual regulation, endometriosis', 45500)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00024', N'Bestop tablet', N'Bestop Tablet is indicated for serious infections for which conventional antibiotics do not work to prevent the development of bacteria resistant to Cipofloxacin.', 85500)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00025', N'Sympal', N'It is used for the symptomatic, short-term treatment of mild to moderate acute pain conditions, such as muscle or joint pain, menstrual pain, toothache.', 45600)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00026', N'Jorexdo', N'It is indicated for the rapid relief of pruritus and the reduction in the number and size of rashes in patients with chronic idiopathic urticaria.', 45900)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00027', N'Ritozol 20mg Capsules', N'The drug is indicated for the following cases: Gastroesophageal reflux disease. Treatment of erosive esophagitis caused by reflux. Long-term treatment of patients with healed esophagitis to prevent recurrence', 22500)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00028', N'Eslo-20', N'Indications of the drug Eslo 20 Treatment of major depressive episodes. Treatment of panic disorder with or without phobia Treatment of social anxiety disorder. Treatment of generalized anxiety disorder.', 26900)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00029', N'Xolair 150 mg', N'Xolair is indicated for the treatment of asthmatic patients with moderate to severe persistent allergic asthma who are reactive (in vitro) to year-round airborne allergens and whose symptoms are not adequately controlled by asthma. inhaled corticosteroids.', 37580)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00030', N'Tagrisso', N'Tagrisso is used to treat certain types of non-small cell lung cancer. Tagrisso is only used if your tumor has a specific genetic marker', 78000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00031', N'Pbbuvir', N'Anti-parasitic, anti-bacterial, anti-viral, anti-fungal drugs', 65420)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00032', N'Secuk ', N'Supplement albumin for the body, restore health to the sick. Helps regenerate liver cells (cirrhosis, hepatitis). Supplement amino acids for the body', 35000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00033', N'Andol S ', N'Fever, headache, muscle aches with runny nose, stuffy nose, rhinitis, sinusitis caused by flu or allergies to the weather.', 87400)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00034', N'Antot', N'Children and adolescents in the period of height growth and development. Cases: overworked people, newly sick people, weak body, thin people, pale, tired, losing weight, eating poorly, sleeping poorly', 64000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00035', N'B Complex C ', N'B Complex C is a preparation used to support the treatment and prevention of diseases caused by vitamin deficiency, improve appetite or supplement minerals for the elderly.', 871000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00036', N'B.Vitab B12', N'B.Vitab B12 is used to prevent and treat calcium deficiency and vitamin B group effectively of Danapha. B.Vitab B12 is suitable for the elderly and children in the developing age.', 72000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00037', N'Bvit 1 250mg', N'Bvit 1 250mg helps to treat the following diseases: Prevention and treatment of edema, polyneuritis, neuralgia, peripheral paralysis, neurotoxicity caused by alcoholism, anti-fatigue, poor appetite.', 98000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00038', N'Cagu Plus', N'Cagu Plus Lozenges contain the active ingredient is Cannabis with bitter taste, slightly soldering properties, has the effect of clearing fire, detoxifying, treating sore throat, treating cough, treating painful swelling and pimples.', 84000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00039', N'Cebral', N'Cebral drug belongs to the list of brain supplements known for its use: Used for people with cerebral blood circulation insufficiency, attention and concentration loss, people who are being treated for depression, people with anemia leading to headaches, vision problems. force is reduced due to anemia.', 215000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00040', N'Cevit 500', N'Participating in collagen production and some other components that make up connective tissue in bones, teeth, blood vessels. Therefore, the lack of vitamin C in the blood vessel wall is unstable, causing bleeding gums or periosteum, swollen gums, easy teeth to fall out', 147000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00041', N'Celgar', N'Celgar medicine helps to treat the following diseases: Use as an anti-oxidant, enhance immunity, support cancer treatment and immunodeficiency diseases in general. Heals ulcers in the lining of the stomach, duodenum, and colon.', 418000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00042', N'Caricin', N'Treatment of infections caused by susceptible bacteria: Lower respiratory tract infections. Acute and chronic bronchitis and pneumonia. Upper respiratory tract infection. Sinusitis, pharyngitis and otitis media. Mild to moderate skin and soft tissue infections.', 66000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00043', N'Calcium D', N'Calcium supplements for the body in the elderly, post-menopausal women (prevention & treatment of osteoporosis, pain relief), pregnant and lactating women, growing children (increase height, treat rickets, malnutrition), fracture patients (helps heal bones).', 342000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00044', N'Buscopan', N'Buscopan is used to relax smooth muscles in the genitourinary tract - urinary tract, gastrointestinal tract, biliary tract.', 47000)
INSERT [dbo].[MEDICAL] ([ID_MEDICAL], [MED_NAME], [MED_DESCRIPTION], [Price]) VALUES (N'ME00045', N'Morphine', N'It is used as a pain reliever. In particular, morphine acts mainly on the central nervous system and on smooth muscle through a number of receptors.', 987000)
GO
INSERT [dbo].[MEDICAL_RECORD] ([ID_MR], [DATE_CREATED], [SYMPTOM], [DOCTOR], [PATIENT]) VALUES (N'MR00001', CAST(N'2022-08-08T00:00:00.000' AS DateTime), N'ho vl', N'US00003', N'US00001')
GO
INSERT [dbo].[SERVICE_DATA] ([ID_SERVICE], [NAME_SERVICE], [PRICE], [Description], [IDF]) VALUES (N'BI00001', N'Periodic health examination', 6000000, N'Comprehensive medical examination of body parts                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         ', N'SKTQ')
INSERT [dbo].[SERVICE_DATA] ([ID_SERVICE], [NAME_SERVICE], [PRICE], [Description], [IDF]) VALUES (N'BI00002', N'Health check for drivers', 500000, N'A driver''s license health check will help you detect diseases that affect driving                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       ', N'SKTQ')
INSERT [dbo].[SERVICE_DATA] ([ID_SERVICE], [NAME_SERVICE], [PRICE], [Description], [IDF]) VALUES (N'BI00003', N'Physical therapy', 550000, N'Relieve neck pain, back pain, herniated disc, injury caused by movement quickly and effectively, helping patients recover soon                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ', N'CXK')
INSERT [dbo].[SERVICE_DATA] ([ID_SERVICE], [NAME_SERVICE], [PRICE], [Description], [IDF]) VALUES (N'BI00004', N'Routine antenatal check-up', 600000, N'Periodic antenatal check-ups help pregnant women monitor the health of mother and baby, and promptly handle abnormalities that occur. In addition, pregnant women also have the opportunity to receive proper health care advice for the most comprehensive development of the baby in the womb.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ', N'SPKHTSS')
INSERT [dbo].[SERVICE_DATA] ([ID_SERVICE], [NAME_SERVICE], [PRICE], [Description], [IDF]) VALUES (N'BI00005', N'Liver and biliary screening', 455000, N'Helping customers screen for early detection of liver disease risks for appropriate treatment.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ', N'THGM')
INSERT [dbo].[SERVICE_DATA] ([ID_SERVICE], [NAME_SERVICE], [PRICE], [Description], [IDF]) VALUES (N'BI00006', N'Liver and biliary screening VIP', 700000, N'Helping customers screen for early detection of liver disease risks for appropriate treatment.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ', N'THGM')
INSERT [dbo].[SERVICE_DATA] ([ID_SERVICE], [NAME_SERVICE], [PRICE], [Description], [IDF]) VALUES (N'BI00007', N'Cancer screening', 650000, N'Helping customers detect cancer cells early and get appropriate treatment                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ', N'SKTQ')
INSERT [dbo].[SERVICE_DATA] ([ID_SERVICE], [NAME_SERVICE], [PRICE], [Description], [IDF]) VALUES (N'BI00008', N'Biological Horoscope', 1000000, N'Help identify changes in the client''s genes, combined with the most up-to-date and modern evidence-based medical knowledge, to make predictions about the risk of dangerous chronic diseases such as cardiovascular disease, diabetes , cancer, ...                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', N'TBGCNG')
INSERT [dbo].[SERVICE_DATA] ([ID_SERVICE], [NAME_SERVICE], [PRICE], [Description], [IDF]) VALUES (N'BI00009', N'Pediatric examination', 800000, N'Care and treatment for children from birth to adulthood.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ', N'N')
INSERT [dbo].[SERVICE_DATA] ([ID_SERVICE], [NAME_SERVICE], [PRICE], [Description], [IDF]) VALUES (N'BI00010', N'PREVENTION SERVICES', 0, N'Vaccination                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             ', N'SKTQ')
INSERT [dbo].[SERVICE_DATA] ([ID_SERVICE], [NAME_SERVICE], [PRICE], [Description], [IDF]) VALUES (N'BI00011', N'Stem cell storage', 150000000, N'Storing and applying this stem cell technology also has a humane meaning in improving lives, maintaining longevity and helping public health.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ', N'TBGCNG')
GO
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'admin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Admin')
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00001', NULL, N'01277', N'HTK', 0, N'0123789', N'email', N'4412', N'ChinhPhan', 20, CAST(N'2001-10-23T00:00:00.000' AS DateTime), N'worker', N'Patient')
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00002', N'TM', N'723410067', N'HCM City', 1, N'7076420965', N'a@email', NULL, N'Philippe Macaire', 42, CAST(N'1980-12-01T00:00:00.000' AS DateTime), NULL, N'Doctor')
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00003', N'N', N'693247989', N'HCM City', 1, N'1789887894', N'b@email', NULL, N'Sergii Bukhtii', 50, CAST(N'1972-12-01T00:00:00.000' AS DateTime), NULL, N'Doctor')
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00004', N'UBXT', N'720163373', N'QN City', 0, N'1806551103', N'c@email', NULL, N'Phan Qu?nh Lan', 30, CAST(N'1992-12-01T00:00:00.000' AS DateTime), NULL, N'Doctor')
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00005', N'SKTQ', N'598604134', N'DN City', 1, N'0054814028', N'd@email', NULL, N'Ph?m Nh?t An', 45, CAST(N'1977-12-01T00:00:00.000' AS DateTime), NULL, N'Doctor')
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00006', N'THGM', N'969683693', N'HN City', 1, N'1334749570', N'e@email', NULL, N'Selina M. Luger', 55, CAST(N'1967-12-01T00:00:00.000' AS DateTime), NULL, N'Doctor')
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00007', N'CXK', N'769135869', N'CT City', 1, N'7925710881', N'f@email', NULL, N'Nguy?n Ð?c Hinh', 52, CAST(N'1970-12-01T00:00:00.000' AS DateTime), NULL, N'Doctor')
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00008', N'SPKHTSS', N'901586361', N'HD City', 0, N'7629516083', N'g@email', NULL, N'Nguy?n Th? Tân Sinh', 41, CAST(N'1981-12-01T00:00:00.000' AS DateTime), NULL, N'Doctor')
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00009', N'TBGCNG', N'174707722', N'VT City', 1, N'2350424977', N'h@email', NULL, N'Tr?n Thanh C?ng', 58, CAST(N'1964-12-01T00:00:00.000' AS DateTime), NULL, N'Doctor')
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00010', N'YHCT', N'859554933', N'TK City', 0, N'1136071246', N'i@gmail', NULL, N'Nguy?n Tuy?t Mai', 52, CAST(N'1970-12-01T00:00:00.000' AS DateTime), NULL, N'Doctor')
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00011', N'HSTC', N'501005885', N'DH City', 1, N'1772895288', N'j@gmail', NULL, N'Tôn Th?t Trí Dung', 56, CAST(N'1966-12-01T00:00:00.000' AS DateTime), NULL, N'Doctor')
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00012', N'CXK', N'12789', N'HCM City', 1, N'123490', N'k@email', NULL, N'Phan Chau Trinh', 0, NULL, NULL, NULL)
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00013', NULL, N'01277', N'HTK', 1, N'0123789', N'email', N'4412', N'ChinhPhan', 18, NULL, N'worker', NULL)
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00014', NULL, N'01277', N'HTK', 1, N'0123789', N'email', N'4412', N'ChinhPhan', 18, NULL, N'worker', NULL)
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00015', NULL, N'01277', N'HTK', 1, N'0123789', N'email', N'4412', N'ChinhPhan', 18, NULL, N'worker', NULL)
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00016', NULL, N'101010', N'HTK', 1, N'123123', N'a@gmail', N'123213', N'chinh', 12, CAST(N'2001-02-23T00:00:00.000' AS DateTime), N'thuthu', N'Patient')
INSERT [dbo].[USER_DATA] ([ID_USER], [IDF], [Phone], [AddressUSER], [GENDER], [CCCD], [EMAIL], [CODEBHYT], [USER_NAME], [USER_AGE], [DOB], [PATIENT_CAREER], [USER_ROLE]) VALUES (N'US00017', NULL, N'0906 959994', N'HTK', 1, N'0906 959994', N'mrkuti1023@gmail.com', N'0906 959994', N'ChÃ­nh Phan', 12, CAST(N'2001-02-13T00:00:00.000' AS DateTime), N'0906 959994', N'Patient')
GO
ALTER TABLE [dbo].[ACCOUNT_LOG] ADD  DEFAULT (getdate()) FOR [Date_Log]
GO
ALTER TABLE [dbo].[BILL] ADD  CONSTRAINT [ID_BILL]  DEFAULT ([DBO].[AUTO_ID_BILL]()) FOR [ID_BILL]
GO
ALTER TABLE [dbo].[DISEASE] ADD  CONSTRAINT [ID_DISEASE]  DEFAULT ([DBO].[AUTO_ID_DISEASE]()) FOR [ID_DISEASE]
GO
ALTER TABLE [dbo].[MEDICAL] ADD  CONSTRAINT [ID_MEDICAL]  DEFAULT ([DBO].[AUTO_ID_MEDICAL]()) FOR [ID_MEDICAL]
GO
ALTER TABLE [dbo].[MEDICAL_RECORD] ADD  CONSTRAINT [ID_MR]  DEFAULT ([DBO].[AUTO_MR]()) FOR [ID_MR]
GO
ALTER TABLE [dbo].[MEDICAL_RECORD] ADD  CONSTRAINT [DF_MEDICAL_RECORD_DATE_CREATED]  DEFAULT (getdate()) FOR [DATE_CREATED]
GO
ALTER TABLE [dbo].[MR_DISEASE] ADD  CONSTRAINT [DF_MR_DISEASE_DATE_DIAGNOSE]  DEFAULT (getdate()) FOR [DATE_DIAGNOSE]
GO
ALTER TABLE [dbo].[prescription] ADD  DEFAULT ([dbo].[AUTO_IDPRE]()) FOR [IDPRE]
GO
ALTER TABLE [dbo].[prescription] ADD  DEFAULT (getdate()) FOR [date_created]
GO
ALTER TABLE [dbo].[prescription_detail] ADD  DEFAULT ((0)) FOR [Quantity]
GO
ALTER TABLE [dbo].[SCHEDULE] ADD  DEFAULT ('No Reply') FOR [CONFIRM]
GO
ALTER TABLE [dbo].[SERVICE_DATA] ADD  CONSTRAINT [ID_SERVICE]  DEFAULT ([DBO].[AUTO_ID_SERVICE]()) FOR [ID_SERVICE]
GO
ALTER TABLE [dbo].[USER_DATA] ADD  CONSTRAINT [ID_USER]  DEFAULT ([DBO].[AUTO_IDUSER]()) FOR [ID_USER]
GO
ALTER TABLE [dbo].[ACCOUNT]  WITH CHECK ADD FOREIGN KEY([ID_USER])
REFERENCES [dbo].[USER_DATA] ([ID_USER])
GO
ALTER TABLE [dbo].[ACCOUNT]  WITH CHECK ADD FOREIGN KEY([ID_USER])
REFERENCES [dbo].[USER_DATA] ([ID_USER])
GO
ALTER TABLE [dbo].[ACCOUNT]  WITH CHECK ADD FOREIGN KEY([ID_USER])
REFERENCES [dbo].[USER_DATA] ([ID_USER])
GO
ALTER TABLE [dbo].[ACCOUNT_LOG]  WITH CHECK ADD FOREIGN KEY([ID_ACCOUNT])
REFERENCES [dbo].[ACCOUNT] ([ID_ACCOUNT])
GO
ALTER TABLE [dbo].[BILL]  WITH CHECK ADD FOREIGN KEY([PATIENT])
REFERENCES [dbo].[USER_DATA] ([ID_USER])
GO
ALTER TABLE [dbo].[BILL]  WITH CHECK ADD FOREIGN KEY([PATIENT])
REFERENCES [dbo].[USER_DATA] ([ID_USER])
GO
ALTER TABLE [dbo].[BILL]  WITH CHECK ADD FOREIGN KEY([PATIENT])
REFERENCES [dbo].[USER_DATA] ([ID_USER])
GO
ALTER TABLE [dbo].[BILL_DETAIL]  WITH CHECK ADD FOREIGN KEY([ID_BILL])
REFERENCES [dbo].[BILL] ([ID_BILL])
GO
ALTER TABLE [dbo].[BILL_DETAIL]  WITH CHECK ADD FOREIGN KEY([ID_BILL])
REFERENCES [dbo].[BILL] ([ID_BILL])
GO
ALTER TABLE [dbo].[BILL_DETAIL]  WITH CHECK ADD FOREIGN KEY([ID_BILL])
REFERENCES [dbo].[BILL] ([ID_BILL])
GO
ALTER TABLE [dbo].[MEDICAL_RECORD]  WITH CHECK ADD FOREIGN KEY([DOCTOR])
REFERENCES [dbo].[USER_DATA] ([ID_USER])
GO
ALTER TABLE [dbo].[MEDICAL_RECORD]  WITH CHECK ADD FOREIGN KEY([DOCTOR])
REFERENCES [dbo].[USER_DATA] ([ID_USER])
GO
ALTER TABLE [dbo].[MEDICAL_RECORD]  WITH CHECK ADD FOREIGN KEY([DOCTOR])
REFERENCES [dbo].[USER_DATA] ([ID_USER])
GO
ALTER TABLE [dbo].[MEDICAL_RECORD]  WITH CHECK ADD FOREIGN KEY([PATIENT])
REFERENCES [dbo].[USER_DATA] ([ID_USER])
GO
ALTER TABLE [dbo].[MEDICAL_RECORD]  WITH CHECK ADD FOREIGN KEY([PATIENT])
REFERENCES [dbo].[USER_DATA] ([ID_USER])
GO
ALTER TABLE [dbo].[MEDICAL_RECORD]  WITH CHECK ADD FOREIGN KEY([PATIENT])
REFERENCES [dbo].[USER_DATA] ([ID_USER])
GO
ALTER TABLE [dbo].[MR_DISEASE]  WITH CHECK ADD FOREIGN KEY([ID_DISEASE])
REFERENCES [dbo].[DISEASE] ([ID_DISEASE])
GO
ALTER TABLE [dbo].[MR_DISEASE]  WITH CHECK ADD FOREIGN KEY([ID_DISEASE])
REFERENCES [dbo].[DISEASE] ([ID_DISEASE])
GO
ALTER TABLE [dbo].[MR_DISEASE]  WITH CHECK ADD FOREIGN KEY([ID_DISEASE])
REFERENCES [dbo].[DISEASE] ([ID_DISEASE])
GO
ALTER TABLE [dbo].[MR_DISEASE]  WITH CHECK ADD FOREIGN KEY([ID_MR])
REFERENCES [dbo].[MEDICAL_RECORD] ([ID_MR])
GO
ALTER TABLE [dbo].[MR_DISEASE]  WITH CHECK ADD FOREIGN KEY([ID_MR])
REFERENCES [dbo].[MEDICAL_RECORD] ([ID_MR])
GO
ALTER TABLE [dbo].[MR_DISEASE]  WITH CHECK ADD FOREIGN KEY([ID_MR])
REFERENCES [dbo].[MEDICAL_RECORD] ([ID_MR])
GO
ALTER TABLE [dbo].[prescription]  WITH CHECK ADD FOREIGN KEY([IDMR])
REFERENCES [dbo].[MEDICAL_RECORD] ([ID_MR])
GO
ALTER TABLE [dbo].[prescription_detail]  WITH CHECK ADD FOREIGN KEY([ID_MEDICAL])
REFERENCES [dbo].[MEDICAL] ([ID_MEDICAL])
GO
ALTER TABLE [dbo].[prescription_detail]  WITH CHECK ADD FOREIGN KEY([IDPRE])
REFERENCES [dbo].[prescription] ([IDPRE])
GO
ALTER TABLE [dbo].[SCHEDULE]  WITH CHECK ADD FOREIGN KEY([ID_SERVICE])
REFERENCES [dbo].[SERVICE_DATA] ([ID_SERVICE])
GO
ALTER TABLE [dbo].[SCHEDULE]  WITH CHECK ADD FOREIGN KEY([Patient])
REFERENCES [dbo].[USER_DATA] ([ID_USER])
GO
ALTER TABLE [dbo].[SCHEDULE]  WITH CHECK ADD FOREIGN KEY([STAFF])
REFERENCES [dbo].[USER_DATA] ([ID_USER])
GO
ALTER TABLE [dbo].[SERVICE_DATA]  WITH CHECK ADD  CONSTRAINT [FK_SERVICE_DATA_FACULTY] FOREIGN KEY([IDF])
REFERENCES [dbo].[FACULTY] ([IDF])
GO
ALTER TABLE [dbo].[SERVICE_DATA] CHECK CONSTRAINT [FK_SERVICE_DATA_FACULTY]
GO
ALTER TABLE [dbo].[USER_DATA]  WITH CHECK ADD FOREIGN KEY([IDF])
REFERENCES [dbo].[FACULTY] ([IDF])
GO
ALTER TABLE [dbo].[USER_DATA]  WITH CHECK ADD FOREIGN KEY([IDF])
REFERENCES [dbo].[FACULTY] ([IDF])
GO
ALTER TABLE [dbo].[USER_DATA]  WITH CHECK ADD FOREIGN KEY([IDF])
REFERENCES [dbo].[FACULTY] ([IDF])
GO


SELECT NAME_SERVICE FROM SERVICE_DATA where ID_SERVICE like 'BI00001'

insert into prescription(IDMR) output inserted.IDPRE values('MR00003')


select * from prescription 