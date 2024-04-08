package com.example.blogging_platform.Commons;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * @author Nicholas Nzovia
 * @On 06/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@MappedSuperclass
public class PO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "uuid", unique = true)
    private String uuid;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_by")
    private LocalDateTime updatedBy;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "deleted_by")
    private LocalDateTime deletedBy;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;


}
