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
group 3 ('C:\database\oradata\tabit\redo03.log') size 10m;
