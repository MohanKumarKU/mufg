Please URL : http://localhost:8080/rover-bot/final-position

This is spring boot executable application running on 8080 port.

I am exposing one REST API to get final position of bot i.e @GetMapping("/final-position") in RoverBotController class.

Sample input : 

{
    "position": {
        "direction": "N",
        "x": 10,
        "y": 10
    },
    "move": [
        {
            "o": "1",
            "l": 90,
            "f": 10
        },
        {
            "o": "2",
            "r": 180,
            "b": 20
        }
    ]
}


Output:

{
    "position": {
        "direction": "E",
        "x": -20,
        "y": 10
    }
}