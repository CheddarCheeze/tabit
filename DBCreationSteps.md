Oracle XE 11g Express Edition

Installation:

	Destination Folder: C:\oraclexe\
	Oracle Home: C:\oraclexe\app\oracle\product\11.2.0\server\
	Oracle Base:C:\oraclexe\
	Port for 'Oracle Database Listener': 1521
	Port for 'Oracle Services for Microsoft Transaction Server': 2030
	Port for 'Oracle HTTP Listener': 8080


This is all done in cmd as administrator
all parameter files for a database must exist in the Oracle HOME (see above), go to the following directory:
	
	cd C:\oraclexe\app\oracle\product\11.2.0\server\database
	vim inittabit.ora
	
Inside the file "inittabit.ora" inside the open file in your text editor copy the following , save it and quit:

	db_name=tabit
	control_files="C:\database\oradata\tabit\control01.ctl"
	
Now set variables: [to see that the value was set properly type echo %ORACLE_SID%] or echo %ORACLE_HOME% for the second
type the following in the cmd:

	set ORACLE_SID=tabit
	set ORACLE_HOME=C:\oraclexe\app\oracle\product\11.2.0\server\

	
create a windows service, type the following in the cmd:

	oradim -new -sid tabit
	
[this automatically starts service]
[how to delete -> oradim -delete -sid tabit]
	
	
to start service: net start OracleServicetabit
to stop service: net stop OracleServicetabit
	
	cd ..
	cd bin
	
connect to the sid (tabit) with the highest authority type in the following in the cmd:

	sqlplus / as sysdba 
	
looks for the inittabit.ora file it opens it determines db_name	

	SQL>startup;   	
	SQL>quit
	
Create a createdb sql file to be executed [location can be anywhere i put them in the
											   following directory C:\oraclexe\scripts]
so create a folder called scripts and then cd to that folder
using any text editor (i have VIM installed on my laptop)
	
	vim createdb.sql
	
Copy the following inside the open file, save it and quit:

	create database tabit
	maxinstances 2
	maxloghistory 1
	maxlogfiles 16
	maxlogmembers 5
	maxdatafiles 100
	datafile 'C:\database\oradata\tabit\system01.dbf' size 300m
	reuse autoextend on next 10240k maxsize unlimited
	extent management local
	sysaux datafile 'C:\database\oradata\tabit\sysaux01.dbf' size 120m reuse
	default temporary tablespace temp tempfile
	'C:\database\oradata\tabit\temp01.dbf' size 10m reuse autoextend on
	next 640k maxsize unlimited
	undo tablespace undotbs1 datafile 'C:\database\oradata\tabit\undotbs1.dbf' size 100m reuse autoextend on next 5120k maxsize unlimited
	character set we8mswin1252
	national character set al16utf16
	logfile group 1 ('C:\database\oradata\tabit\redo01.log') size 10m,
	group 2 ('C:\database\oradata\tabit\redo02.log') size 10m,
	group 3 ('C:\database\oradata\tabit\redo03.log') size 10m
	
go back to C:\ in the cmd

	cd ../..
	
then type in the following as it is in the cmd:
	
	mkdir database 
	cd database 
	mkdir oradata 
	cd oradata 
	mkdir tabit 
	cd tabit
	
in the same directory that you currently are type in, in the cmd:

	sqlplus / as sysdba
	
now execute the command from scripts
	
	SQL> @C:\oraclexe\scripts\createdb.sql;
	
wait a few moments... BOOM!
	
	Database created. 
	
	SQL>quit
	
Change directory to "C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin" with the following command in the cmd:

	cd ../../..
	cd oraclexe\app\oracle\product\11.2.0\server\rdbms\admin
	
now connect to sqlplus
	
	sqlplus / as sysdba

enter the following command to execute the following file and wait:

	SQL> @?\rdbms\admin\catalog.sql;
	
after completion execute the following command and wait:

	SQL> @?\rdbms\admin\catproc.sql;
	

And now besides the XE database we have a TABIT database.

	SQL>exit

THIS IS ALSO VERY IMPORTANT:
how to create a user and grant access (this is all done from the command line)

	sqlplus / as sysdba

Type in the following with the same username and password[THIS IS BECAUSE THE JAVA CODE IN GITHUB DATAHANDLER CLASS HAS THIS RECORDED]
	
	SQL>create user nanunezr identified by password tabit0427;
	SQL>grant connect to nanunezr;
	SQL>grant connect, resource, dba to nanunezr;
	SQL>grant create session to nanunezr;
	SQL>grant unlimited tablespace to nanunezr;
	SQL>grant select, update, insert, delete on TABLENAMES*** to nanunezr;
	
	SQL>exit
	
	
Now to log in as a regular user and with all privileges instead of dba admin

int the cmd:	
	sqlplus
	
	Enter username: nanunezr;
	Enter password: tabit0427;
	
	and you are now logged in

	
And that is it.
The other stuff is for JDeveloper READ IT.
	
	