################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/BlockMergeBase.cpp \
../src/Pruebas_TADCasilla.cpp \
../src/Pruebas_TADTablero.cpp \
../src/TADCasilla.cpp \
../src/TADJuego.cpp \
../src/TADTablero.cpp \
../src/entorno.cpp 

OBJS += \
./src/BlockMergeBase.o \
./src/Pruebas_TADCasilla.o \
./src/Pruebas_TADTablero.o \
./src/TADCasilla.o \
./src/TADJuego.o \
./src/TADTablero.o \
./src/entorno.o 

CPP_DEPS += \
./src/BlockMergeBase.d \
./src/Pruebas_TADCasilla.d \
./src/Pruebas_TADTablero.d \
./src/TADCasilla.d \
./src/TADJuego.d \
./src/TADTablero.d \
./src/entorno.d 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


