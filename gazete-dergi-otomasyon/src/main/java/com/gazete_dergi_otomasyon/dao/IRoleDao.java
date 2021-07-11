package com.gazete_dergi_otomasyon.dao;

import com.gazete_dergi_otomasyon.model.ERole;
import com.gazete_dergi_otomasyon.model.Role;

public interface IRoleDao {

    Role getRole(ERole role);

}
