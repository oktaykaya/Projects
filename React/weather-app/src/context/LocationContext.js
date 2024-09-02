import { createContext, useEffect, useState } from "react";

const LocationContext = createContext();

export const LocationProvider = ({ children }) => {
  const [location, setLocation] = useState({ latitude: null, longitude: null });

  useEffect(() => {
    const getLocation = async () => {
      try {
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(
            (position) => {
              try {
                setLocation({
                  latitude: position.coords.latitude,
                  longitude: position.coords.longitude,
                });
              } catch (innerError) {
                console.error("Error setting location: ", innerError);
              }
            },
            (error) => {
              console.error("Error getting location: ", error);
            }
          );
        } else {
          console.error("Geolocation is not supported by this browser.");
        }
      } catch (error) {
        console.error("Unexpected error: ", error);
      }
    };

    getLocation();
  }, []);

  return (
    <LocationContext.Provider value={location}>
      {children}
    </LocationContext.Provider>
  );
};

export default LocationContext;
