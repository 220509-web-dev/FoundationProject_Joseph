-- mock data for land-arch.sql
set search_path to landarch_app;

-- mock users for app_users
insert into app_users(first_name, last_name, username, password)
values 
('Raymond', 'Sanchez', 'rsanchez78', 'raymonds78'),
('Sally', 'Fields', 'sfields67', 'sallyf67'),
('Joseph', 'Luna', 'jluna00', 'joell000'),
('Lily', 'Johnson', 'ljohnson83', 'lilyj830'),
('Ubeja', 'Anderson', 'uanderson79', 'ubejaa79'),
('Gloria', 'Brown', 'gbrown88', 'gloriab88'),
('Rosemary', 'Rodriguez', 'rrodriguez91', 'rosemaryr91'),
('Derek', 'Chapman', 'dchapman73', 'derekc73'),
('Crystal', 'Kain', 'ckain92', 'crystalk92'),
('Mark', 'Smylie', 'msmylie89', 'marks890');