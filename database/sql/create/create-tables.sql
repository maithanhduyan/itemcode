-- public.product definition
-- Drop table
-- DROP TABLE public.product;
CREATE TABLE public.product (
    id varchar(255) NOT NULL,
    active int4 NULL,
    badge varchar(255) NULL,
    code varchar(255) NULL,
    cost_price float8 NULL,
    created_by varchar(255) NULL,
    created_date timestamp NULL,
    description varchar(255) NULL,
    image_url varchar(255) NULL,
    in_stock int4 NULL,
    link_url varchar(255) NULL,
    "name" varchar(255) NULL,
    promo_price float8 NULL,
    promo_status int4 NULL,
    sale_price float8 NULL,
    sku varchar(255) NULL,
    updated_by varchar(255) NULL,
    updated_date timestamp NULL,
    CONSTRAINT product_pkey PRIMARY KEY (id)
);