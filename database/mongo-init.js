db = db.getSiblingDB('mutants_db');

db.createUser({
    user: 'mutants_user',
    pwd: 'mutants_pw',
    roles: [
        {
            role: 'readWrite',
            db: 'mutants_db',
        },
    ],
});

db = db.getSiblingDB('mutants_db_test');

db.createUser({
    user: 'mutants_user',
    pwd: 'mutants_pw',
    roles: [
        {
            role: 'readWrite',
            db: 'mutants_db_test',
        },
    ],
});