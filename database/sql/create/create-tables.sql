-- public.product definition
-- Drop table
-- DROP TABLE public.product;
CREATE TABLE public.product (
    id varchar(255) NOT NULL,
    active int4 NULL,
    code varchar(255) NULL,
    cost_price int4 NULL DEFAULT 0,
    created_by varchar(255) NULL,
    created_date timestamp NULL,
    description varchar(255) NULL,
    name varchar(255) NULL,
    updated_by varchar(255) NULL,
    updated_date timestamp NULL,
    CONSTRAINT product_pkey PRIMARY KEY (id)
);

-- Drop table
-- DROP TABLE public.users;
CREATE TABLE public.users (
    id varchar(255) NOT NULL,
    username varchar(255) NULL,
    encryptedpassword varchar(255) NULL,
    active int4 NULL,
    created_by varchar(255) NULL,
    updated_by varchar(255) NULL,
    created_date timestamp NULL,
    description varchar(255) NULL,
    updated_date timestamp NULL,
    CONSTRAINT uk_lms6rj21w37sofw5m7ln40ebh null,
    CONSTRAINT uk_r43af9ap4edm43mmtq01oddj6 null,
    CONSTRAINT users_pkey PRIMARY KEY(id)
);

-- Drop table
-- DROP TABLE public.persistent_logins;
CREATE TABLE public.persistent_logins (
    series varchar(255) NOT NULL,
    last_used timestamp NULL,
    "token" varchar(255) NULL,
    username varchar(255) NULL,
    CONSTRAINT persistent_logins_pkey PRIMARY KEY (series)
);