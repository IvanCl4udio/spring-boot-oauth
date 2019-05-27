package net.ivancl4udio.apps.oauth2server.repository;

import net.ivancl4udio.apps.oauth2server.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

}