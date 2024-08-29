
CREATE TABLE alien_civilization (
   id UUID PRIMARY KEY,
   name VARCHAR(50) NOT NULL
);


CREATE TABLE invasion_plan (
    id UUID PRIMARY KEY,
    plan_name VARCHAR(100) NOT NULL,
    alien_civilization_id UUID,
    CONSTRAINT fk_alien_civilization FOREIGN KEY (alien_civilization_id) REFERENCES alien_civilization(id)
);

create table alien_fleet
(
    id   uuid PRIMARY KEY,
    fleetName    VARCHAR(50) not null,
    alien_civilization_id UUID,
    CONSTRAINT fk_alien_civilization FOREIGN KEY (alien_civilization_id) REFERENCES alien_civilization(id)

);

create table defense_system
(
    id   uuid PRIMARY KEY,
    systemName VARCHAR(50) not null,
    invasion_plan_id UUID,
    CONSTRAINT fk_invasion_plan FOREIGN KEY (invasion_plan_id) REFERENCES invasion_plan(id)

);
create table resource
(
    id  uuid PRIMARY KEY,
    resourceName  VARCHAR(50) not null,
    invasion_plan_id UUID,
    CONSTRAINT fk_invasion_plan FOREIGN KEY (invasion_plan_id) REFERENCES invasion_plan(id)
);
create table target
(
    id uuid PRIMARY KEY,
    targetName  VARCHAR(50) not null,
    invasion_plan_id UUID,
    CONSTRAINT fk_invasion_plan FOREIGN KEY (invasion_plan_id) REFERENCES invasion_plan(id)

);
CREATE TABLE invasion_plan_resource (
     invasion_plan_id UUID,
     resource_id UUID,
     PRIMARY KEY (invasion_plan_id, resource_id),
     CONSTRAINT fk_invasion_plan_resource FOREIGN KEY (invasion_plan_id) REFERENCES invasion_plan(id),
     CONSTRAINT fk_resource_invasion_plan FOREIGN KEY (resource_id) REFERENCES resource(id)
);