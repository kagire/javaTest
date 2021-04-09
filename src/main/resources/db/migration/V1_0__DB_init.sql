CREATE TABLE public.employee (
    employee_id bigint NOT NULL,
    first_name character varying NOT NULL,
    last_name character varying NOT NULL,
    department_id integer NOT NULL,
    job_title character varying NOT NULL,
    gender character varying(6) NOT NULL,
    date_of_birth date NOT NULL
);

ALTER TABLE public.employee OWNER TO postgres;

ALTER TABLE public.employee ALTER COLUMN employee_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.employee_employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (employee_id);

