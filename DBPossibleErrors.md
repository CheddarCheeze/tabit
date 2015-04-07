Possible errors when using the database:
1) FIRST ALWAYS VERIFY YOUR ENVIRONMENT VARIABLES ARE SET!
	echo %ORACLE_SID%
this must say:
	tabit
if not, set it:
	set ORACLE_SID=tabit

SAME THING FOR ORACLE_HOME
	

2)ORA-12560 Listener adapter error

to solve this problem go to a command prompt as administrator, type in:
	services.msc
this will open a window
look for:
	OracleServicetabit 
right click it and select properties,
look for:
	Startup type:
select
	Automatic
click apply, then ok then close. Restart computer and it should now work.
If youre still having problems refer to 1).
Nicolas
	