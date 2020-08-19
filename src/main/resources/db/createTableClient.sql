CREATE TABLE client
    (
     id int IDENTITY(1,1) PRIMARY KEY, 		/* código interno         */
     name VARCHAR(100) NOT NULL ,			/* nome do cliente        */
     cpf VARCHAR(100) NOT NULL,				/* cpf do cliente         */
     address VARCHAR(100) NULL ,			/* endereco do cliente    */
     created_date DATETIME NULL ,			/* data de auditoria da gravacao no banco         */
	 modified_date DATETIME NULL 			/* data de auditoria de alteracao no banco        */
);