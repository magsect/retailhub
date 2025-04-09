package model.entity;

/*This class represents a well-designed product entity for a retail application,
following modern Java development practices and leveraging powerful frameworks to reduce boilerplate and ensure data integrity*/


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stockQuantity;

    @Column(nullable = false, unique = true)
    private String sku; //Stock Keeping Unit

    @Column(nullable = false)
    private String category;

    private String brand;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected  void onUpdate(){
        updatedAt = LocalDateTime.now();
    }

    /*
## Package Declaration

package com.retailhub.model.entity;


Purpose: Organizes the class into a namespace called com.retailhub.model.entity
Problem Solved: Prevents naming conflicts and organizes code in a hierarchical structure, making the codebase more maintainable as it grows
Convention: Follows Java's package naming convention (reverse domain name)

Import Statements
import jakarta.persistence.*;


Technology: Jakarta Persistence API (JPA) - the newer version of Java Persistence API
Purpose: Provides annotations for Object-Relational Mapping (ORM)
Problem Solved: Bridges the gap between object-oriented Java code and relational databases

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


Technology: Project Lombok
Purpose: Reduces boilerplate code through annotations
Problem Solved: Eliminates the need to manually write getters, setters, constructors, equals, hashCode, and toString methods

import java.math.BigDecimal;
import java.time.LocalDateTime;


Purpose: Imports Java standard library classes for precise decimal calculations and date-time handling
Problem Solved: Provides proper data types for financial calculations (BigDecimal) and modern date-time operations (LocalDateTime)

Class Annotations
@Entity


Technology: JPA
Purpose: Marks this class as a persistent entity that should be mapped to a database table
Problem Solved: Enables automatic table creation and ORM functionality

@Table(name = "products")


Technology: JPA
Purpose: Specifies the database table name this entity maps to
Problem Solved: Allows custom table naming, decoupling the database schema from Java class names

@Data


Technology: Lombok
Purpose: Generates getters, setters, equals, hashCode, and toString methods
Problem Solved: Reduces hundreds of lines of boilerplate code to a single annotation

@NoArgsConstructor
@AllArgsConstructor


Technology: Lombok
Purpose: Generates a no-args constructor and a constructor with all fields
Problem Solved: Provides flexibility in object creation without writing constructor code

Class Fields and Field Annotations
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


Technology: JPA
Purpose: Marks the field as the primary key with auto-increment capability
Problem Solved: Handles unique identification of records and automatic ID generation

@Column(nullable = false)
private String name;


Technology: JPA
Purpose: Defines column constraints (NOT NULL in this case)
Problem Solved: Ensures data integrity at the database level

@Column(length = 1000)
private String description;


Technology: JPA
Purpose: Sets the maximum length for the description column
Problem Solved: Optimizes database storage by specifying the appropriate column size

@Column(nullable = false)
private BigDecimal price;


Technology: JPA + Java BigDecimal
Purpose: Stores monetary values with precision
Problem Solved: Avoids floating-point errors in financial calculations

@Column(nullable = false)
private Integer stockQuantity;


Technology: JPA
Purpose: Tracks available inventory
Problem Solved: Maintains inventory data with NOT NULL constraint

@Column(nullable = false, unique = true)
private String sku; // Stock Keeping Unit


Technology: JPA
Purpose: Enforces uniqueness of product identifiers
Problem Solved: Prevents duplicate SKUs in the database

@Column(nullable = false)
private String category;


Technology: JPA
Purpose: Categorizes products
Problem Solved: Enables product organization and filtering

private String brand;


Technology: JPA
Purpose: Stores brand information
Problem Solved: Allows brand-based queries and filtering

private LocalDateTime createdAt;
private LocalDateTime updatedAt;


Technology: Java Time API + JPA
Purpose: Tracks creation and modification timestamps
Problem Solved: Provides audit trail for data changes

Lifecycle Callback Methods
@PrePersist
protected void onCreate() {
    createdAt = LocalDateTime.now();
    updatedAt = LocalDateTime.now();
}


Technology: JPA lifecycle callbacks
Purpose: Automatically sets creation timestamps before entity is saved
Problem Solved: Ensures consistent timestamp creation without manual intervention

@PreUpdate
protected void onUpdate() {
    updatedAt = LocalDateTime.now();
}


Technology: JPA lifecycle callbacks
Purpose: Updates the modification timestamp whenever the entity is updated
Problem Solved: Maintains accurate "last modified" information automatically

Overall Technology Benefits
1. JPA/Jakarta Persistence:



- Solves the object-relational impedance mismatch




Provides database-agnostic persistence
Simplifies CRUD operations
Manages database schema through annotations

2. Lombok:



- Reduces code verbosity by 50-80%




Decreases chances of bugs in boilerplate code
Improves code readability and maintainability

3. Java Time API (LocalDateTime):



- Offers immutable date-time classes




Provides better timezone handling than legacy Date class
Simplifies date arithmetic and formatting

4. BigDecimal:



- Ensures precise decimal calculations




Prevents rounding errors in financial operations
Provides proper decimal arithmetic operations

This class represents a well-designed product entity for a retail application, following modern Java development practices and leveraging powerful frameworks to reduce boilerplate and ensure data integrity.
*/
}
