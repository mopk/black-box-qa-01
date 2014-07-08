call _emptyDumpDir.cmd
mongodump -h localhost:27017 -d test --out ../dump