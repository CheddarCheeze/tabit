Oracle XE 11g Express Edition

Installation:

	Destination Folder: C:\oraclexe\
	Oracle Home: C:\oraclexe\app\oracle\product\11.2.0\server\
	Oracle Base:C:\oraclexe\
	Port for 'Oracle Database Listener': 1521
	Port for 'Oracle Services for Microsoft Transaction Server': 2030
	Port for 'Oracle HTTP Listener': 8080


This is all done in cmd as administrator
all parameter files for a database must exist in the Oracle HOME (see above)
	cd C:\oraclexe\app\oracle\product\11.2.0\server\database
	vim initabit.ora
	db_name=tabit
	control_files="C:\database\oradata\tabit\control01.ctl"
	
	set variables:
	set ORACLE_SID=tabit
[to see that the value was set properly type echo %ORACLE_SID%]
	
	set ORACLE_HOME=C:\oraclexe\app\oracle\product\11.2.0\server\
[same as above]
	
create a windows service
	oradim -new -sid tabit
[this automatically starts service]
	
[how to delete -> oradim -delete -sid tabit]
	
	
to start service: net start OracleServicetabit
to stop service: net stop OracleServicetabit
	
	cd .. into bin
	
connect to the sid (tabit) with the highest authority
	sqlplus / as sysdba 
look for the initabit.ora file it opens it determines db_name	
	SQL>startup;   
	
	SQL>quit
	
Create a createdb sql file to be executed [location can be anywhere i put them in the
											   following directory C:\oraclexe\scripts]
so create a folder called scripts and then cd to that folder
using any text editor (i have VIM installed on my laptop)
Copy the following

	vim createdb.sql
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
	
go back to C:\
	
	mkdir database cd database mkdir oradata cd oradata mkdir tabit cd tabit
	
	sqlplus / as sysdba
now execute the command from scripts
	SQL> @C:\oraclexe\scripts\createdb.sql;
	
wait a few moments... BOOM!
	Database created. 
	
	SQL>quit
	
cd to C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin
	
now connect to sqlplus
	
	sqlplus / as sysdba

enter the following command to execute it

	SQL> @?\rdbms\admin\catalog.sql;
after completion

	SQL> @?\rdbms\admin\catproc.sql;
	
And now besides the XE database we have a TABIT database.


how to create a user and grant access (this is all done from the command line)

	sqlplus / as sysdba
	
	create user nanunezr identified by password tabit0427;
	grant connect to nanunezr;
	grant connect, resource, dba to nanunezr;
	grant create session to nanunezr;
	grant unlimited tablespace to nanunezr;
	grant select, update, insert, delete on TABLENAMES*** to nanunezr;
	
	exit
	
	
	now to log in as a regular user and with all privileges instead of dba admin
	
	sqlplus
	
	Enter username: nanunezr;
	Enter password: tabit0427;
	
	and you are now logged in

	

	
	