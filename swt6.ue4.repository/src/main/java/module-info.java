module swt6.ue4.repository {
    requires swt6.ue4.domain;
    requires java.persistence;

    exports swt6.repository.interfaces;
    exports swt6.repository.impl;
}