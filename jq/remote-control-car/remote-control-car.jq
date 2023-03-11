def new_remote_control_car:
  {
     "battery_percentage": 100,
     "distance_driven_in_meters": 0,
     "nickname": null
   }
;

def new_remote_control_car(nickname):
  new_remote_control_car + {"nickname": nickname}
;

def display_distance:
   "\(.distance_driven_in_meters) meters"
;

def display_battery:
  # Implement the required output string
  ""
;

def drive:
  # Update the input's attributes as required
  .
;
