import { Link } from "react-router-dom";
import React from "react";
import { useAuth } from "./security/AuthContext";

export function HeaderComponent() {
  const authContext = useAuth();
  const isAuth = authContext.isAuthenticated;

  function logout() {
    authContext.logout(false);
  }

  // console.log(authContext);
  return (
    <header className={"border-bottom border-light border-5 mb-5 p-2"}>
      <div className={"container"}>
        <div className={"row"}>
          <nav className={"navbar navbar-expand-lg"}>
            <a
              className={"navbar-brand ms-2 fs-2 fw-bold text-black"}
              href={"http://localhost:3000"}
            >
              Todo
            </a>
            <div className={"collapse navbar-collapse"}>
              <ul className={"navbar-nav"}>
                <li className={"nav-item"}>
                  {isAuth && (
                    <Link className={"nav-link"} to={"todos"}>
                      Todo
                    </Link>
                  )}
                </li>
                <li>
                  {isAuth && (
                    <Link className={"nav-link"} to={"/welcome/test"}>
                      Home
                    </Link>
                  )}
                </li>
              </ul>
            </div>
            <ul className={"navbar-nav"}>
              <li className={"nav-item"}>
                {!isAuth && (
                  <Link className={"nav-link"} to={"/"}>
                    Login
                  </Link>
                )}
              </li>
              <li className={"nav-item"}>
                {isAuth && (
                  <Link className={"nav-link"} to={"/logout"} onClick={logout}>
                    Logout
                  </Link>
                )}
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </header>
  );
}