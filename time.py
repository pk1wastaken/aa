import time

def transmit_signal(signal, duration):
    print(f"Transmitting '{signal}' at time sleep({duration}) seconds...")
    time.sleep(duration)

def time_division_multiplexing(signals, durations):
    if len(signals) != len(durations):
        raise ValueError("Number of signals must be equal to the number of durations")

    print("Time Division Multiplexing started for the following signals:")
    for i, signal in enumerate(signals):
        transmit_signal(signal, durations[i])

    print("Time Division Multiplexing completed")

signals = ["Signal 1", "Signal 2", "Signal 3"]
durations = [2, 3, 1]

try:
    time_division_multiplexing(signals, durations)
except KeyboardInterrupt:
    print("Keyboard interrupt detected. Time Division Multiplexing stopped.") 
