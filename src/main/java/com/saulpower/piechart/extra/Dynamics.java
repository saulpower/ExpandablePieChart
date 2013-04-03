/*
 * Copyright (c) 2010, Sony Ericsson Mobile Communication AB. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met:
 *
 *    * Redistributions of source code must retain the above copyright notice, this 
 *      list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *    * Neither the name of the Sony Ericsson Mobile Communication AB nor the names
 *      of its contributors may be used to endorse or promote products derived from
 *      this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.saulpower.piechart.extra;


/**
 * Utility class used to handle flinging within a specified limit.
 */
public abstract class Dynamics {
    
    public final String TAG = this.getClass().getSimpleName();
    
    /**
     * The maximum delta time, in milliseconds, between two updates
     */
    private static final int MAX_TIMESTEP = 50;

    /** The current position */
    protected float mPosition;

    /** The current velocity */
    protected float mVelocity;

    /** The time of the last update */
    protected long mLastTime = 0;

    /**
     * Sets the state of the dynamics object. Should be called before starting
     * to call update.
     * 
     * @param position The current position.
     * @param velocity The current velocity in pixels per second.
     * @param now The current time
     */
    public void setState(final float position, final float velocity, final long now) {
        mVelocity = velocity;
        mPosition = position;
        mLastTime = now;
    }

    /**
     * Returns the current position. Normally used after a call to update() in
     * order to get the updated position.
     * 
     * @return The current position
     */
    public float getPosition() {
        return mPosition;
    }

    /**
     * Gets the velocity. Unit is in pixels per second.
     * 
     * @return The velocity in pixels per second
     */
    public float getVelocity() {
        return mVelocity;
    }

    /**
     * Used to find out if the list is at rest, that is, has no velocity.
     * Normally used to know if more calls to update are
     * needed.
     * 
     * @param velocityTolerance Velocity is regarded as 0 if less than
     *            velocityTolerance
     * 
     * @return true if list is at rest, false otherwise
     */
    public boolean isAtRest(final float velocityTolerance) {
    	
        final boolean standingStill = Math.abs(mVelocity) < velocityTolerance;
        
        return standingStill;
    }

    /**
     * Updates the position and velocity.
     * 
     * @param now The current time
     */
    public void update(final long now) {
    	
        int dt = (int) (now - mLastTime);
        
        if (dt > MAX_TIMESTEP) {
            dt = MAX_TIMESTEP;
        }

        onUpdate(dt);

        mLastTime = now;
    }

    /**
     * Updates the position and velocity.
     * 
     * @param dt The delta time since last time
     */
    abstract protected void onUpdate(int dt);
}
